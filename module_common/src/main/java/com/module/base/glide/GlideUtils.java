package com.module.base.glide;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.module.base.R;

import java.io.File;

/**
 * On 2020/10/20
 */
public class GlideUtils
{
    //****************************1、以下 圆形头像******************************/

    /**
     * @param context
     * @param string   图片来源为String
     * @param targetIv 目标控件
     */
    public static void loadCircleAvatar(Context context, String string, ImageView targetIv) {
        loadCircleAvatar(context, string, 0, null, null, null, targetIv, 0, 0);
    }

    /**
     * @param context
     * @param string   图片来源为String
     * @param targetIv 目标控件
     * @param w        宽
     * @param h        高
     */
    public static void loadCircleAvatar(Context context, String string, ImageView targetIv, int w, int h) {
        loadCircleAvatar(context, string, 0, null, null, null, targetIv, w, h);
    }

    /**
     * @param context
     * @param resourceId 图片来源为Integer
     * @param targetIv   目标控件
     */
    public static void loadCircleAvatar(Context context, Integer resourceId, ImageView targetIv) {
        loadCircleAvatar(context, "", resourceId, null, null, null, targetIv, 0, 0);
    }

    /**
     * @param context
     * @param resourceId 图片来源为Integer
     * @param targetIv   目标控件
     * @param w          宽
     * @param h          高
     */
    public static void loadCircleAvatar(Context context, Integer resourceId, ImageView targetIv, int w, int h) {
        loadCircleAvatar(context, "", resourceId, null, null, null, targetIv, w, h);
    }

    /**
     * @param context
     * @param file     图片来源为File
     * @param targetIv 目标控件
     */
    public static void loadCircleAvatar(Context context, File file, ImageView targetIv) {
        loadCircleAvatar(context, "", 0, file, null, null, targetIv, 0, 0);
    }

    /**
     * @param context
     * @param file     图片来源为File
     * @param targetIv 目标控件
     * @param w        宽
     * @param h        高
     */
    public static void loadCircleAvatar(Context context, File file, ImageView targetIv, int w, int h) {
        loadCircleAvatar(context, "", 0, file, null, null, targetIv, w, h);
    }

    /**
     * @param context
     * @param uri      图片来源为Uri
     * @param targetIv 目标控件
     */
    public static void loadCircleAvatar(Context context, Uri uri, ImageView targetIv) {
        loadCircleAvatar(context, "", 0, null, uri, null, targetIv, 0, 0);
    }

    /**
     * @param context
     * @param uri      图片来源为Uri
     * @param targetIv 目标控件
     * @param w        宽
     * @param h        高
     */
    public static void loadCircleAvatar(Context context, Uri uri, ImageView targetIv, int w, int h) {
        loadCircleAvatar(context, "", 0, null, uri, null, targetIv, w, h);
    }

    /**
     * @param context
     * @param model    图片来源为byte[]
     * @param targetIv 目标控件
     */
    public static void loadCircleAvatar(Context context, byte[] model, ImageView targetIv) {
        loadCircleAvatar(context, "", 0, null, null, model, targetIv, 0, 0);
    }

    /**
     * @param context
     * @param model    图片来源为byte[]
     * @param targetIv 目标控件
     * @param w        宽
     * @param h        高
     */
    public static void loadCircleAvatar(Context context, byte[] model, ImageView targetIv, int w, int h) {
        loadCircleAvatar(context, "", 0, null, null, model, targetIv, w, h);
    }

    /**
     * 加载圆形图片（以头像为例）
     * 以下1-5个来源中，每次只能有一个有值
     */
    private static void loadCircleAvatar(Context context, String string, Integer resourceId, File file, Uri uri, byte[] model, ImageView targetIv, int w, int h) {

        //来源于String
        if (!TextUtils.isEmpty(string) && resourceId == 0 && file == null && uri == null && model == null) {
            if (w != 0 && h != 0) {
                Glide.with(context)
                        .load(string)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .override(w, h)
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            } else {
                Glide.with(context)
                        .load(string)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            }
        }

        //来源于Integer
        else if (resourceId != 0 && TextUtils.isEmpty(string) && file == null && uri == null && model == null) {
            if (w != 0 && h != 0) {
                Glide.with(context)
                        .load(resourceId)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .override(w, h)
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            } else {
                Glide.with(context)
                        .load(resourceId)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            }
        }
        //来源于File
        else if (file != null && TextUtils.isEmpty(string) && resourceId == 0 && uri == null && model == null) {
            if (w != 0 && h != 0) {
                Glide.with(context)
                        .load(file)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .override(w, h)
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            } else {
                Glide.with(context)
                        .load(file)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            }
        }

        //来源于Uri
        else if (uri != null && TextUtils.isEmpty(string) && resourceId == 0 && file == null && model == null) {
            if (w != 0 && h != 0) {
                Glide.with(context)
                        .load(uri)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .override(w, h)
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            } else {
                Glide.with(context)
                        .load(uri)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            }
        }

        //来源于byte[]
        else if (model != null && TextUtils.isEmpty(string) && resourceId == 0 && file == null && uri == null) {
            if (w != 0 && h != 0) {
                Glide.with(context)
                        .load(model)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .override(w, h)
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            } else {
                Glide.with(context)
                        .load(model)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.mipmap.demo_car)
                        .error(R.mipmap.demo_car)
                        .centerCrop()
                        .crossFade()
                        .transform(new TransformCircle(context))
                        .into(targetIv);
            }
        }
    }
}
