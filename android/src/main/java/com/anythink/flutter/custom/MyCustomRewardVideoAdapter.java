package com.anythink.flutter.custom;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.anythink.core.api.AdError;
import com.anythink.flutter.reward.ATAdRewardVideoManger;
import com.anythink.flutter.reward.ATRewardVideoHelper;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;

import java.util.HashMap;
import java.util.Map;

public class MyCustomRewardVideoAdapter extends CustomRewardVideoAdapter {
    String mUnitid;
    String mPayload;

//    /***
//     * load ad
//     */
//    private void startLoad(final Context context) {
//
//        final RewardedVideoAdListener rewardedVideoAdListener = new RewardedVideoAdListener() {
//            @Override
//            public void onError(Ad ad, AdError error) {
//                if (mLoadListener != null) {
//                    mLoadListener.onAdLoadError(error.getErrorCode() + "", "" + error.getErrorMessage());
//                }
//            }
//
//            @Override
//            public void onAdLoaded(Ad ad) {
//                if (mLoadListener != null) {
//                    mLoadListener.onAdCacheLoaded();
//                }
//            }
//
//            @Override
//            public void onAdClicked(Ad ad) {
//                if (mImpressionListener != null) {
//                    mImpressionListener.onRewardedVideoAdPlayClicked();
//                }
//            }
//
//            @Override
//            public void onLoggingImpression(Ad ad) {
//                if (mImpressionListener != null) {
//                    mImpressionListener.onRewardedVideoAdPlayStart();
//                }
//            }
//
//            @Override
//            public void onRewardedVideoCompleted() {
//                if (mImpressionListener != null) {
//                    mImpressionListener.onRewardedVideoAdPlayEnd();
//                }
//
//                if (mImpressionListener != null) {
//                    mImpressionListener.onReward();
//                }
//            }
//
//            @Override
//            public void onRewardedVideoClosed() {
//                if (mImpressionListener != null) {
//                    mImpressionListener.onRewardedVideoAdClosed();
//                }
//
//            }
//        };
//
//        rewardedVideoAd = new RewardedVideoAd(context.getApplicationContext(), mUnitid);
//        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder adConfig = rewardedVideoAd
//                .buildLoadAdConfig()
//                .withAdListener(rewardedVideoAdListener)
//                .withFailOnCacheFailureEnabled(true)
//                .withRVChainEnabled(true);
//
//        adConfig.withRewardData(new RewardData(mUserId, mUserData));
//
//        if (!TextUtils.isEmpty(mPayload)) {
//            adConfig.withBid(mPayload);
//        }
//        rewardedVideoAd.loadAd(adConfig.build());
//    }

    @Override
    public void destory() {
//        try {
//            if (rewardedVideoAd != null) {
//                rewardedVideoAd.setAdListener(null);
//                rewardedVideoAd.destroy();
//            }
//        } catch (Exception e) {
//        }
    }


    @Override
    public void loadCustomNetworkAd(Context context, Map<String, Object> serverExtras, Map<String, Object> localExtras) {
        Log.e("qwer","kk===loadCustomNetworkAd="+serverExtras);
        if (serverExtras.containsKey("unit_id")) {
            mUnitid = (String) serverExtras.get("unit_id");
        } else {
            if (mLoadListener != null) {
                mLoadListener.onAdLoadError("", "facebook sdkkey is empty.");
            }
            return;
        }
//        FacebookInitManager.getInstance().initSDK(context.getApplicationContext(), serverExtras);
//
//        if (serverExtras.containsKey("payload")) {
//            mPayload = serverExtras.get("payload").toString();
//        }

//        startLoad(context);

        ATRewardVideoHelper helper = ATAdRewardVideoManger.getInstance().getHelper(mUnitid);
        Map<String, Object> map = new HashMap<>();
        map.put("tolerateTimeout",20);
        helper.loadRewardedVideo(mUnitid,map);
    }

    @Override
    public boolean isAdReady() {
//        if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded()) {
//            return false;
//        }
//        if (rewardedVideoAd.isAdInvalidated()) {
//            return false;
//        }
        return true;
    }

    @Override
    public boolean setUserDataConsent(Context context, boolean isConsent, boolean isEUTraffic) {
        return false;
    }

    @Override
    public void show(Activity activity) {
//        if (rewardedVideoAd != null) {
//            rewardedVideoAd.show();
//        }
    }

    @Override
    public String getNetworkSDKVersion() {
//        return FacebookInitManager.getInstance().getNetworkVersion();
        return "";
    }

    @Override
    public String getNetworkName() {
//        return FacebookInitManager.getInstance().getNetworkName();
        return "";
    }

    @Override
    public String getNetworkPlacementId() {
        return mUnitid;
    }
}
