package com.derek.net.retrofitnetrx.util;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.derek.net.retrofitnetrx.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * @author shenxingzhe
 * @Description: 类的描述 -
 * @date 2017/4/13.
 * @email yong.wang@chemayi.com
 */

public class GlideUtil {

    private static DrawableRequestBuilder loadUrlToReqBuilder(String imgUrl, ImageView imageView) {
        return Glide.with(imageView.getContext()).load(imgUrl)
                .placeholder(R.drawable.bg_defautl_imageview).error(R.drawable.bg_defautl_imageview);
    }

    private static DrawableRequestBuilder<String> loadUrlToReqBuilder(String imgUrl, ImageView imageView, @DrawableRes int
            drawableRes) {
        return Glide.with(imageView.getContext()).load(imgUrl).placeholder(drawableRes).error(drawableRes);
    }

    public static void loadUrl(String imgUrl, ImageView imageView) {
        loadUrlToReqBuilder(imgUrl, imageView).into(imageView);
    }

    public static void loadUrl(String imgUrl, ImageView imageView, @DrawableRes int drawableRes) {
        loadUrlToReqBuilder(imgUrl, imageView, drawableRes).into(imageView);
    }

    public static void loadUrl(String imgUrl, ImageView imageView, @DrawableRes int drawableRes, int radius) {
        loadUrlToReqBuilder(imgUrl, imageView, drawableRes)
                .bitmapTransform(new RoundedCornersTransformation(imageView.getContext(), radius, 0)).into(imageView);
    }

    public static DrawableRequestBuilder loadAvatarUrlToReqBuilder(String imgUrl, ImageView imageView) {
        return loadAvatarUrlToReqBuilder(imgUrl, imageView, R.drawable.bg_defautl_imageview);
    }

    public static DrawableRequestBuilder loadAvatarUrlToReqBuilder(String imgUrl, ImageView imageView, @DrawableRes int drawableRes) {
        return Glide.with(imageView.getContext()).load(imgUrl)
                .placeholder(drawableRes)
                .error(drawableRes);
    }

    public static void loadAvatarUrlWithRadius(String imgUrl, ImageView imageView) {
        loadAvatarUrlToReqBuilder(imgUrl, imageView)
                .bitmapTransform(new CenterCrop(imageView.getContext()),
                        new RoundedCornersTransformation(imageView.getContext(), 8, 0))
                .into(imageView);
    }

    public static void loadAvatarUrlWithRadius(String imgUrl, ImageView imageView, @DrawableRes int drawableRes) {
        loadAvatarUrlToReqBuilder(imgUrl, imageView, drawableRes)
                .bitmapTransform(new CenterCrop(imageView.getContext()),
                        new RoundedCornersTransformation(imageView.getContext(), 8, 0))
                .into(imageView);
    }

    public static void loadAvatarUrlWithRoundness(String imgUrl, ImageView imageView) {
        loadAvatarUrlToReqBuilder(imgUrl, imageView)
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .into(imageView);
    }

    public static void loadAvatarUrlWithRoundness(String imgUrl, ImageView imageView, @DrawableRes int drawableRes) {
        loadAvatarUrlToReqBuilder(imgUrl, imageView, drawableRes)
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .into(imageView);
    }
}
