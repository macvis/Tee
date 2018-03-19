package compound.adaptors;

import compound.duck.Quackable;
import compound.goose.Goose;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class GooseAdaptor implements Quackable {
    Goose goose;

    public GooseAdaptor(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
