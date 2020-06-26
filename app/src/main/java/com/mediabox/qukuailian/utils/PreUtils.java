package com.mediabox.qukuailian.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/**
 * 本地持久化的工具类
 *
 * @author lizhaoyong
 */
public class PreUtils {
    private static final String FILE_NAME = "config";

    // 存储到sp中
    public static void setParam(Context context, String key, Object object) {
        String type = object.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }
        editor.commit();
    }

    // 获取sp中的值
    public static Object getParam(Context context, String key,
                                  Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);

        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        } else if ("Integer".equals(type)) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if ("Boolean".equals(type)) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if ("Float".equals(type)) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if ("Long".equals(type)) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    // 对象的存取 对象必须implements Serializable
    public static Object getObject(Context context, String key) {
        try {
            SharedPreferences sharedata = context.getSharedPreferences(FILE_NAME, 0);
            if (sharedata.contains(key)) {
                String string = sharedata.getString(key, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is = new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    Object readObject = is.readObject();
                    return readObject;
                }
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //所有异常返回null
        return null;
    }


    public static void saveObject(Context context, String key, Object object) {
        try {
            // 保存对象
            SharedPreferences.Editor sharedata = context.getSharedPreferences(FILE_NAME, 0).edit();
            // 清除对象
            if (object == null) {
                SharedPreferences.Editor editor = sharedata.remove(key);
                editor.commit();
                return;
            }
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(object);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            sharedata.putString(key, bytesToHexString);
            sharedata.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * * desc:将数组转为16进制
     * * @param bArray
     * * @return
     * * modified:
     */
    public static String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] StringToBytes(String data) {
        String hexString = data.toUpperCase().trim();
        if (hexString.length() % 2 != 0) {
            return null;
        }
        byte[] retData = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i++) {
            int int_ch;  // 两位16进制数转化后的10进制数
            char hex_char1 = hexString.charAt(i); ////两位16进制数中的第一位(高位*16)
            int int_ch3;
            if (hex_char1 >= '0' && hex_char1 <= '9')
                int_ch3 = (hex_char1 - 48) * 16;   //// 0 的Ascll - 48
            else if (hex_char1 >= 'A' && hex_char1 <= 'F')
                int_ch3 = (hex_char1 - 55) * 16; //// A 的Ascll - 65
            else
                return null;
            i++;
            char hex_char2 = hexString.charAt(i); ///两位16进制数中的第二位(低位)
            int int_ch4;
            if (hex_char2 >= '0' && hex_char2 <= '9')
                int_ch4 = (hex_char2 - 48); //// 0 的Ascll - 48
            else if (hex_char2 >= 'A' && hex_char2 <= 'F')
                int_ch4 = hex_char2 - 55; //// A 的Ascll - 65
            else
                return null;
            int_ch = int_ch3 + int_ch4;
            retData[i / 2] = (byte) int_ch;//将转化后的数放入Byte里
        }
        return retData;
    }


    public static void saveArrayList(ArrayList<String> mList, Context context) {
        setParam(context, "Status_size", mList.size());

        for (int i = 0; i < mList.size(); i++) {
            mList.remove("Status_" + i);
            setParam(context, "Status_" + i, mList.get(i));
        }

    }

    /**
     * 本地化存储list数据
     *
     * @param mList
     * @param context
     * @param key
     */
    public static void saveArrayListByKey(ArrayList<String> mList,
                                          Context context, String key) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mList.size(); i++) {
            if (i == mList.size() - 1) {
                sb.append(mList.get(i));
            } else {
                sb.append(mList.get(i)).append(",");
            }

        }
        setParam(context, key, sb.toString());
    }

    /**
     * 获取本地存储的String转化为字符串集合
     *
     * @param context
     * @param key
     * @return
     */
    public static ArrayList<String> loadArrayListByKey(Context context,
                                                       String key) {
        ArrayList<String> list = new ArrayList<String>();
        String str = (String) getParam(context, key, "");
        if (str != null && str != "") {
            String[] arr = str.split(",");
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        } else {
            return null;
        }
    }

    public static ArrayList<String> loadArrayList(Context context) {
        ArrayList<String> list = new ArrayList<String>();
        int size = (Integer) getParam(context, "Status_size", 0);
        // System.out.println("size = " + size);
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                list.add((String) getParam(context, "Status_" + i, ""));
            }
        }

        return list;
    }
}
