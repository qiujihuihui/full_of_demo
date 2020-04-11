package com.full.demo.businessdemo.manager;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

/**
 * 运行时权限
 */
public class PermissionHelper {
    // 询问拨打电话的权限
    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public static void call(Activity context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            callPhone(context);
        }
    }

    private static void callPhone(Activity context) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        context.startActivity(intent);
    }

    public static void dealPermissionsResult(Activity context, int requestCode, int[] grantResults) {
        if (requestCode == PermissionHelper.PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                PermissionHelper.callPhone(context);
                return;
            }
//            Toast.makeText(MainActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
            if (!ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.CALL_PHONE)) {
                AlertDialog dialog = new AlertDialog.Builder(context).setMessage("该功能需要访问电话的权限，不开启将无法正常工作！")
                        .setPositiveButton("确定", (dialogInterface, i) -> {}).create();
                dialog.show();
            }
        }
    }
}
