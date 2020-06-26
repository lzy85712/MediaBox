package com.mediabox.qukuailian.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {
    private static String mYear;
    private static String mMonth;
    private static String mDay;
    private static StringBuffer sb;
    private static Bitmap bitmap;

    public static final String TAG = "MyUtils";
    public static Context context;

    // 精确计算listview的高度,type处理2个平行listview的高度计算问题
    public static void setListViewHeightBasedOnChildren(ListView listView, Context context, String type) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int listViewWidth = w_screen - dip2px(context, 16);
        int widthSpec;
        // 处理平行listview的问题
        if (type != null) {
            widthSpec = View.MeasureSpec.makeMeasureSpec(listViewWidth / 2, View.MeasureSpec.AT_MOST);
        } else {
            widthSpec = View.MeasureSpec.makeMeasureSpec(listViewWidth, View.MeasureSpec.AT_MOST);

        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            //计算子项View 的宽高
            listItem.measure(widthSpec, 0);
            //统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    /**
     * 计算gridview高度
     * @param gridView

     */



    public static void setGridViewHeightBasedOnChildren(GridView gridView) {

        // 获取GridView对应的Adapter

        ListAdapter listAdapter = gridView.getAdapter();

        if (listAdapter == null) {
            return;
        }

        int rows;

        int columns = 0;

        int horizontalBorderHeight = 0;

        Class<?> clazz = gridView.getClass();

        try {

            // 利用反射，取得每行显示的个数

            Field column = clazz.getDeclaredField("mRequestedNumColumns");


            column.setAccessible(true);

            columns = (Integer) column.get(gridView);


            // 利用反射，取得横向分割线高度


            Field horizontalSpacing = clazz.getDeclaredField("mRequestedHorizontalSpacing");

            horizontalSpacing.setAccessible(true);

            horizontalBorderHeight = (Integer) horizontalSpacing.get(gridView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 判断数据总数除以每行个数是否整除。不能整除代表有多余，需要加一行

        if (listAdapter.getCount() % columns > 0) {

            rows = listAdapter.getCount() / columns + 1;

        } else {

            rows = listAdapter.getCount() / columns;
        }

        int totalHeight = 0;

        for (int i = 0; i < rows; i++) { // 只计算每项高度*行数

            View listItem = listAdapter.getView(i, null, gridView);

            listItem.measure(0, 0); // 计算子项View 的宽高

            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度

        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();

        params.height = totalHeight + horizontalBorderHeight * (rows - 1);// 最后加上分割线总高度

        gridView.setLayoutParams(params);
    }


    // MD5加密
    public static String md5(String string) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // MD5加密 护理宝
    public static String encode(long milSecond, String str) {
        String md5_one = md5(getDateToString(milSecond) + str);
        //md5(md5_one.substring(4,21));
//        LogUtils.d("md5_one = " + md5_one);
//        LogUtils.d("subString = " + md5_one.substring(4, 21 + 4));
//        LogUtils.d("md5_two = " + md5(md5_one.substring(4, 21 + 4)));
        return md5(md5_one.substring(4, 21 + 4));
    }


    public static String getDateToString(long milSecond) {
        String pattern = "yyyy-MM-dd";
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String getFormatTimeToString(long milSecond) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


    // 隐藏软键盘
    public static Boolean hideInputMethod(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            return imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        return false;
    }


    // 判断当前点击屏幕的地方是否是软键盘：
    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    // 生成单例的bitmap
    public static Bitmap getSingleBitmap(Activity activity) {
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(activity.getWindowManager()
                    .getDefaultDisplay().getWidth(), activity.getWindowManager()
                    .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
            return bitmap;
        } else {
            return bitmap;
        }
    }


    // 截取括号外的字符串
    public static String getKehuName(String str) {
        if (str == null) {
            return "";
        } else {
            int position = str.indexOf("(");
            if (position != -1) {
                return str.substring(0, position);
            } else {
                return str;
            }

        }
    }


    // 判断内容宽度是否超出其可用宽度
    public static boolean isOverFlowed(final TextView tv) {

        final boolean flag;

        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int availableWidth = tv.getWidth() - tv.getPaddingLeft()
                        - tv.getPaddingRight();
                Paint textViewPaint = tv.getPaint();
                float textWidth = textViewPaint.measureText(tv.getText()
                        .toString());
                if (textWidth - (availableWidth * 2) > 0) {
                    // Log.i(TAG, "显示展开");
                } else {
                    // Log.i(TAG, "不显示展开");
                }
                // Log.i(TAG, "textWidth = " + textWidth);
                // Log.i(TAG, "availableWidth = " + availableWidth);
            }
        });

        return false;
    }

    // "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$"
    public static boolean isMobile(String mobiles) {
        // ^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|7[06-8])\\d{8}$
        // ^(13\\d|14[57]|15[012356789]|18\\d|17[013678])\\d{8}$
        Pattern p = Pattern
                .compile("^(13\\d|14[57]|15[012356789]|18\\d|17[013678])\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static boolean isQQ(String mobiles) {
        Pattern p = Pattern.compile("^[1-9][0-9]{4,}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    // 获取图片
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis); // /把流转化为Bitmap图片
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap readBitmapAutoSize(String filePath, int outWidth,
                                            int outHeight) {
        // outWidth和outHeight是目标图片的最大宽度和高度，用作限制
        FileInputStream fs = null;
        BufferedInputStream bs = null;
        try {
            fs = new FileInputStream(filePath);
            bs = new BufferedInputStream(fs);
            BitmapFactory.Options options = setBitmapOption(filePath, outWidth,
                    outHeight);
            return BitmapFactory.decodeStream(bs, null, options);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bs.close();
                fs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // 字符串时间转分钟
    public static int StringTimeToMinute(String time) {
        if (time.length() == 1 || time.length() == 2) {
            return Integer.parseInt(time);
        } else if (time.length() == 3) {
            return Integer.parseInt(time.subSequence(0, 1).toString()) * 60
                    + Integer.parseInt(time.substring(1, 3).toString());
        } else if (time.length() == 4) {
            if (time.equals("0000")) {
                return 0;
            } else {
                return Integer.parseInt(time.subSequence(0, 2).toString()) * 60
                        + Integer.parseInt(time.substring(2, 4).toString());
            }
        }
        return 0;
    }

    // 将分时数据补全
    public static String[] timeDataCheck(String[] timeData) {
        ArrayList<String> al_check = new ArrayList<String>();
        al_check.add(timeData[0]);
        // 第一个数据和给定时间差了多少分钟
        int frist_sub = 0;
        // 初始数据的校验
        // 如果开始的数据就漏了用最近的数据数据类似2000-1530
        String[] time_start_end = timeData[0].split("-");
        // 第一组数据的时间类似2100
        String frist_data_time = timeData[1].split(",")[1];
        String time_start = time_start_end[0];
        // Log.i(TAG, "frist_data_time = " + frist_data_time);
        // Log.i(TAG, "time_start = " + time_start);

        frist_sub = StringTimeToMinute(frist_data_time)
                - StringTimeToMinute(time_start);
        // 如果数据有误差补上数据，数据为第一个给的数据
        Log.i(TAG, "frist_sub = " + frist_sub);
        if (frist_sub >= 0) {
            for (int i = 0; i < frist_sub; i++) {
                al_check.add(timeData[1]);
            }
        } else {
            frist_sub = 1440 + frist_sub;
            for (int i = 0; i < frist_sub; i++) {
                al_check.add(timeData[1]);
            }
        }
        // 后续数据的校验
        for (int i = 0; i < timeData.length; i++) {
            // Log.i(TAG, "data " + i + " = " + timeData[i]);
            if (i > 0 && i < timeData.length - 1) {
                String[] temp1 = timeData[i].split(",");
                String[] temp2 = timeData[i + 1].split(",");
                // Log.i(TAG, "temp1 = " + temp1[1]);
                // Log.i(TAG, "temp2 = " + temp2[1]);
                int num1 = 0;
                int num2 = 0;
                // 处理格式为20161109,3,281.88,20161109和20161109,19,281.1,20161109类型数据
                if (temp1[1].length() == 1 || temp1[1].length() == 2) {
                    num1 = Integer.parseInt(temp1[1]);
                    // 处理格式为20161109,109,279.87,20161109类型数据
                } else if (temp1[1].length() == 3) {
                    int hour = Integer.parseInt(temp1[1].substring(0, 1));
                    int min = Integer.parseInt(temp1[1].substring(1,
                            temp1[1].length()));
                    num1 = hour * 60 + min;
                    // 处理格式为20161108,2107,280.25,20161109类型数据
                } else if (temp1[1].length() == 4) {
                    int hour = Integer.parseInt(temp1[1].substring(0, 2));
                    int min = Integer.parseInt(temp1[1].substring(2,
                            temp1[1].length()));
                    num1 = hour * 60 + min;
                }
                // 处理格式为20161109,3,281.88,20161109和20161109,19,281.1,20161109类型数据
                if (temp2[1].length() == 1 || temp2[1].length() == 2) {
                    num2 = Integer.parseInt(temp2[1]);
                    // 处理格式为20161109,109,279.87,20161109类型数据
                } else if (temp2[1].length() == 3) {
                    int hour = Integer.parseInt(temp2[1].substring(0, 1));
                    int min = Integer.parseInt(temp2[1].substring(1,
                            temp2[1].length()));
                    num2 = hour * 60 + min;
                    // 处理格式为20161108,2107,280.25,20161109类型数据
                } else if (temp2[1].length() == 4) {
                    int hour = Integer.parseInt(temp2[1].substring(0, 2));
                    int min = Integer.parseInt(temp2[1].substring(2,
                            temp2[1].length()));
                    num2 = hour * 60 + min;
                }
                // Log.i(TAG, "num2 = " + num2);
                // Log.i(TAG, "num1 = " + num1);
                int num_need_add = num2 - num1;
                if (num_need_add == 1) {
                    // 表示数据连续
                    al_check.add(timeData[i]);
                } else {
                    // Log.i(TAG, "num_need_add = " + num_need_add);
                    // 表示数据不连续，需要补上数据
//                    if (num_need_add > 1) {
//                        for (int j = 0; j < num_need_add; j++) {
//                            al_check.add(timeData[i]);
//                        }
//                    }
                }
            }
        }

        // 集合转数组
        String[] arr_check = new String[al_check.size()];
        for (int i = 0; i < al_check.size(); i++) {
            arr_check[i] = (String) al_check.get(i);
        }
        // for (int i = 0; i < al_check.size(); i++) {
        // Log.i(TAG, "check Data = " + al_check.get(i));
        // }
        return arr_check;
    }

    private static BitmapFactory.Options setBitmapOption(String file,
                                                         int width, int height) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        // 设置只是解码图片的边距，此操作目的是度量图片的实际宽度和高度
        BitmapFactory.decodeFile(file, opt);

        int outWidth = opt.outWidth; // 获得图片的实际高和宽
        int outHeight = opt.outHeight;
        opt.inDither = false;
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        // 设置加载图片的颜色数为16bit，默认是RGB_8888，表示24bit颜色和透明通道，但一般用不上
        opt.inSampleSize = 1;
        // 设置缩放比,1表示原比例，2表示原来的四分之一....
        // 计算缩放比
        if (outWidth != 0 && outHeight != 0 && width != 0 && height != 0) {
            int sampleSize = (outWidth / width + outHeight / height) / 2;
            opt.inSampleSize = sampleSize;
        }

        opt.inJustDecodeBounds = false;// 最后把标志复原
        return opt;
    }

    public static String formatTimeBySecond(int sec) {
        if (sb == null) {
            sb = new StringBuffer();
        } else {
            sb.setLength(0);
        }
        int ss = 1;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = sec / dd;
        long hour = (sec - day * dd) / hh;
        long minute = (sec - day * dd - hour * hh) / mi;
        long second = (sec - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = sec - day * dd - hour * hh - minute * mi - second
                * ss;
        // Log.i(TAG, "day = " + day + "hour = " + hour + "minute = " + minute
        // + "second = " + second);
        String strDay = day < 10 ? "0" + day : "" + day; // 天
        String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
        String strSecond = second < 10 ? "0" + second : "" + second;// 秒
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : ""
                + milliSecond;// 毫秒
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : ""
                + strMilliSecond;
        return strDay + "天" + strHour + "时" + strMinute + "分" + strSecond + "秒";
    }

    public static String formatTimeBySecondToRemind(long sec) {
        if (sb == null) {
            sb = new StringBuffer();
        } else {
            sb.setLength(0);
        }
        int ss = 1;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = sec / dd;
        long hour = (sec - day * dd) / hh;
        long minute = (sec - day * dd - hour * hh) / mi;
        // long second = (sec - day * dd - hour * hh - minute * mi) / ss;
        // long milliSecond = sec - day * dd - hour * hh - minute * mi - second
        // * ss;
        // Log.i(TAG, "day = " + day + "hour = " + hour + "minute = " + minute);
        String strDay = day < 10 ? "0" + day : "" + day; // 天
        String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
        // String strSecond = second < 10 ? "0" + second : "" + second;// 秒
        // String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : ""
        // + milliSecond;// 毫秒
        // strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : ""
        // + strMilliSecond;
        // Log.i(TAG, "strDay = " + strDay);
        return strDay + "天" + strHour + "时" + strMinute + "分";
    }

    // 去除长传字符串中看不见的空格换行等
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    // 去除空格
    public static String replaceNewline(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // 获取当前是星期几
    public static int getDayofWeek() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            return 6;
        } else if ("2".equals(mWay)) {
            return 0;
        } else if ("3".equals(mWay)) {
            return 1;
        } else if ("4".equals(mWay)) {
            return 2;
        } else if ("5".equals(mWay)) {
            return 3;
        } else if ("6".equals(mWay)) {
            return 4;
        } else if ("7".equals(mWay)) {
            return 5;
        } else {
            return 0;
        }
    }

    // 判断APP在后台还是前台
    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        for (RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // 判断app是否在运行
    public static boolean appIsRunning(Context context) {
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> list = am.getRunningTasks(100);
        for (RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals("com.tf099.metal01")
                    && info.baseActivity.getPackageName().equals(
                    "com.tf099.metal01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static String getData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        return mYear + "年" + mMonth + "月" + mDay + "日";
    }

    // java Unicode转UTF-8代码
    private static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    public static boolean isNetWorkConnect(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    // System.out.println(i + "===状态==="
                    // + networkInfo[i].getState());
                    // System.out.println(i + "===类型==="
                    // + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean isWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }


    // 适配api在19以下的沉浸式显示效果
    public static void adapterBelowNineteen(RelativeLayout rl_base_title,
                                            ImageView iv_back, TextView tv_title, Context context) {
        // 代码设置高度
        ViewGroup.LayoutParams params = rl_base_title.getLayoutParams();
        params.height = MyUtils.dip2px(context, 50);
        rl_base_title.setLayoutParams(params);

        LayoutParams iv_params = (LayoutParams) iv_back.getLayoutParams();
        iv_params.addRule(RelativeLayout.CENTER_VERTICAL);
        iv_back.setLayoutParams(iv_params);

        LayoutParams tv_params = (LayoutParams) tv_title.getLayoutParams();
        tv_params.addRule(RelativeLayout.CENTER_IN_PARENT);
        tv_title.setLayoutParams(tv_params);
    }


    /**
     * 获取通知栏权限是否开启
     */

    public static class NotificationsUtils {
        private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
        private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";

        @SuppressLint("NewApi")
        public static boolean isNotificationEnabled(Context context) {

            AppOpsManager mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            ApplicationInfo appInfo = context.getApplicationInfo();
            String pkg = context.getApplicationContext().getPackageName();
            int uid = appInfo.uid;

            Class appOpsClass = null;
      /* Context.APP_OPS_MANAGER */
            try {
                appOpsClass = Class.forName(AppOpsManager.class.getName());
                Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE,
                        String.class);
                Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);

                int value = (Integer) opPostNotificationValue.get(Integer.class);
                return ((Integer) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return false;
        }
    }


}
