package com.anythink.flutter.custom;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;

import java.util.Map;

public class MyCustomRewardVideoAdapter extends CustomRewardVideoAdapter {
    ATRewardVideoAd rewardedVideoAd;
    String mUnitid;
    String mPayload;

    /***
     * load ad
     */
    private void startLoad(final Context context) {

        ATRewardVideoExListener rewardedVideoAdListener = new ATRewardVideoExListener() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdFailed(AdError adError) {

            }

            @Override
            public void onRewardedVideoAdPlayStart(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdPlayEnd(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdClosed(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdPlayClicked(ATAdInfo atAdInfo) {

            }

            @Override
            public void onReward(ATAdInfo atAdInfo) {

            }

            @Override
            public void onDeeplinkCallback(ATAdInfo atAdInfo, boolean b) {

            }

            @Override
            public void onDownloadConfirm(Context context, ATAdInfo atAdInfo, ATNetworkConfirmInfo atNetworkConfirmInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayStart(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayEnd(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayFailed(AdError adError, ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayClicked(ATAdInfo atAdInfo) {

            }

            @Override
            public void onAgainReward(ATAdInfo atAdInfo) {

            }
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
        };

        rewardedVideoAd = new ATRewardVideoAd(context.getApplicationContext(), mUnitid);
        rewardedVideoAd.setAdListener(rewardedVideoAdListener);
        rewardedVideoAd.load();

//        adConfig.withRewardData(new RewardData(mUserId, mUserData));
//
//        if (!TextUtils.isEmpty(mPayload)) {
//            adConfig.withBid(mPayload);
//        }
//        rewardedVideoAd.loadAd(adConfig.build());
    }

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

        startLoad(context);

//        ATRewardVideoHelper helper = ATAdRewardVideoManger.getInstance().getHelper(mUnitid);
//        Map<String, Object> map = new HashMap<>();
//        map.put("tolerateTimeout",20);
//        helper.loadRewardedVideo(mUnitid,map);
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
        return "1.0.0";
    }

    @Override
    public String getNetworkName() {
        return "moloco";
    }

    @Override
    public String getNetworkPlacementId() {
        return mUnitid;
    }

    @Override
    public boolean startBiddingRequest(Context context, Map<String, Object> serverExtra, Map<String, Object> localExtra, ATBiddingListener biddingListener) {
        Log.e("qwer","kk====startBiddingRequest");
        mUnitid= (String) serverExtra.get("unit_id");
        Log.e("qwer","kk=mUnitid===="+mUnitid);
        Log.e("qwer","kk=mUnitid===="+serverExtra);

        Moloco.initialize(new MolocoInitParams(context, "TESTBIRD:xN1yvyK9jNSWghVU", new MediationInfo("moloco")), new MolocoInitializationListener() {
            @Override
            public void onMolocoInitializationStatus(@NonNull MolocoInitStatus molocoInitStatus) {
                Log.e("qwer","kkk===onMolocoInitializationStatus==="+molocoInitStatus.getInitialization().name()+"===="+molocoInitStatus.getDescription());

            }
        });
        return true;
    }
}
