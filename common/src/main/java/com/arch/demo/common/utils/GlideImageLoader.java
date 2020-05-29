package com.arch.demo.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.arch.demo.common.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

/**
 * ================================================
 * 作    者：zrx
 *
 *
 * @date 2019/3/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path)
                .apply(RequestOptions
                        .placeholderOf(R.mipmap.new_list_default_img)
                        .error(R.mipmap.new_list_default_img)
                )
                .into(imageView);
    }
}
