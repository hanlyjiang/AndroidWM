package com.watermark.androidwm.sample.watermark.wmutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.watermark.androidwm.sample.watermark.param.wmtext.WmTextParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: wangsengren
 * @Description: 图片加载工具类
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class NewBitmapUtils {

    public static Bitmap loadBitmap(String picturePath) throws FileNotFoundException {
        Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
        if (bitmap == null) {
            throw new FileNotFoundException("Couldn't open " + picturePath);
        }
        return bitmap;
    }

    /**
     * 保存带水印的Bitmap
     *
     * @param bitmap
     * @param wmTextParam
     */
    public static String saveWmBitmap(Bitmap bitmap, WmTextParam wmTextParam) {
        File f = new File(getNewWmFile(wmTextParam.getFilePath(), wmTextParam.getQuality()));
        try {
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.JPEG, wmTextParam.getQuality(), out);
            out.flush();
            out.close();
            return f.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载Bitmap原图
     *
     * @param filePath
     * @return
     */
    public static Bitmap decodeBitmapFromFile(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static Bitmap decodeSampledBitmapFromPath(String path,
                                                     int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    /**
     * 根据宽高计算压缩比例
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    private static String getFileName(String filePath) {
        return filePath.substring(0, filePath.lastIndexOf("."));
    }

    private static String getFileEnd(String filePath) {
        return filePath.substring(filePath.lastIndexOf("."));
    }

    public static String getNewWmFile(String filePath, int quality) {
        String fileName = getFileName(filePath);
        String fileEnd = getFileEnd(filePath);
        return fileName + "_wmtext_" + quality + "_" + System.currentTimeMillis() + fileEnd;
    }
}
