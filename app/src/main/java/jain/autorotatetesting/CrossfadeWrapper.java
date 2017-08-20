package jain.autorotatetesting;

import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;

class CrossfadeWrapper implements ICrossfader {
    private Crossfader mCrossfader;

    CrossfadeWrapper(Crossfader crossfader) {
        this.mCrossfader = crossfader;
    }

    @Override
    public void crossfade() {
        mCrossfader.crossFade();
    }

    @Override
    public boolean isCrossfaded() {
        return mCrossfader.isCrossFaded();
    }
}
