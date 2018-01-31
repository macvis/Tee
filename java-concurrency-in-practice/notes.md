Java并发编程实战  
--  

####前言
* 要点：  
    1. 线程也被称为轻量级进程
    2. 线程带来的风险：
        1) 安全性
        2) 活跃性：  
            在开发并发代码时，一定要注意线程安全性是不可破坏的
        3) 性能问题：  
            在多线程程序中，当线程调度器临时挂起活跃线程并转而运行另一个线程时，就会频繁的出现上下文切换操作，这种操作将带来极大的开销：  
            保存和恢复执行上下文，丢失局部性，并且CPU时间将更多的花在线程调度而不是线程运行上。
    4. 线程无处不在：  
        框架通过在框架线程中调用应用程序代码将并发性引入到程序中。在代码中将不可避免的访问应用程序状态，因此所有访问这些状态的代码路径都必须是线程安全的。  
    5. 几个在应用程序之外的线程中调用应用程序的代码(是不是守护线程?)  
        java.util.Timer;  
        各种Servlet;   
        RMI

###第一部分，基础知识  
####2.0 线程安全性
* 要编写线程安全的代码，其核心在于要对状态访问操作进行管理，特别是对共享的(Shared)和可变的(Mutable)状态的访问
    * 共享，意味着变量可以由多个线程同时访问
    * 可变，意味着变量的值在其生命周期内可以发生变化
    - 一个对象是否需要是线程安全的，取决于它是否被多个线程访问
    - 要使得对象时线程安全的，就需要使用同步机制来协同对对象可变状态的访问
    - 在编写并发应用程序时，一种正确的编程方法就是：首先使代码正确运行，然后再提高代码的速度

####2.1 什么是线程安全性
* 当多个线程访问某个类时，不管运行时环境采用何种调度方式或者这些线程将如何交替执行，并且在主调代码中不需要任何额外的同步或协同，这个类都能表现出正确的行文，那么就称这个类时线程安全的。  

示例1：一个无状态的Servlet
```java
@ThreadSafe
public class StatelessFactorizer implements Servlet{
    public void service(ServletRequest req, ServletResponse resp){
        java.math.BigInteger i = extractFromRequest(req);
        java.math.BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }
}
```
StatelessFactorizer是无状态的：既不包含任何域，也不包含任何对其他类中域的引用。
* 无状态对象一定是线程安全的。
    * 大多数Servlet都是无状态的。
    * 只有当Servlet在处理请求时需要保存一些信息，线程安全性才会成为一个问题   
    
####2.2 原子性  

示例2：在没有同步的情况下统计已处理请求数量的Servlet(不安全，不能这么写)
```java
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet{
    private long count = 0;
    public long getCount(){
        return count;
    }
    public void service(ServletRequest req, ServletResponse res){
        java.math.BigInteger i = extractFromRequest(req);
        java.math.BigInteger[] factors = factor(i);
        count++;
        encodeIntoResponse(res, factors);
    }
}
```
上述类是非线程安全的，虽然能在单线程环境中正确运行，但是很可能会丢失一些更新操作。虽然递增操作count++是一种紧凑的语法，使其看上去只是一个操作，但这个操作并非原子的，因而它并不会作为一个不可分割的操作来执行  
* 在并发编程中，这种由于不恰当的执行时序而出现不正确的结果是一种非常重要的情况，它有一个正式的名字：**竞态条件**。
####2.2.1 竞态条件  
* 当某个计算结果的正确性取决于多个线程的交替执行时序时，那么就会发生竞态条件
    * 最常见的竞态条件类型就是先检查后执行(check-then-act)操作，即通过一个可能失效的观测结果来决定下一步的动作  
    * 要获得正确的结果，必须取决于时间的发生时序。
* 竞态条件的本质：基于一种可能失效的观察结果来做出判断或者执行某个计算，举例：
```text
A和B约在一号大街的星巴克见面。
然后A赶到一号大街时却发现有两个星巴克。
于是A进入第一家星巴克，没有看到B，只好走出来。
就在A走出第一家星巴克的时候，B也赶到第一家星巴克，只是B从后门进的。
所以这就是一种失效的观察结果

即先检查，后执行
```
####2.2.2 延迟初始化中的竞态条件
* 延迟初始化：将对象的初始化操作推迟到实际被使用时才进行，同时要确保只被初始化一次。
示例：延迟初始化中的竞态条件，不要这么做
```java
public class LazyInitRace{
    private ExpensiveObject instance = null;
    public ExpensiveObject getInstance(){
        if(instance == null){
            instance = new ExpensiveObject();
            return instance;
        }
    }
}
```
上述例子中，如果同时有两个线程执行getInstance，那么A看到instance为空的同时，B也在调用getInstance方法，那么此时的instance是否为空，要取决于不可预测的时序，包括线程的调度方式，以及A需要花费多长时间来初始化ExpensiveObject并设置Instance。如果当B检查时，instance为空没那么在两次调用getInstance时可能会得到不同的结果  
* 与大多数并发错误一样，竞态条件并不总是会产生错误，还需要某种不恰当的执行时序。
