package com.example.mvvmlibrary.widget.loadingdrawable;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.mvvmlibrary.R;

import java.lang.ref.WeakReference;

public class LoadingDialog extends Dialog {


    public LoadingDialog(Context context) {
        super(context);
    }

    public static class Builder{

        WeakReference<Context> mWeakReference;
        private String message;
        private boolean isCancelable;
        private boolean isCancelOutside;


        public Builder(Context context) {
            mWeakReference = new WeakReference<Context>(context);
        }

        /**
         * 设置提示信息
         * @param message
         * @return
         */

        public Builder setMessage(String message){
            this.message=message;
            return this;
        }

        /**
         * 设置是否可以按返回键取消
         * @param isCancelable
         * @return
         */

        public Builder setCancelable(boolean isCancelable){
            this.isCancelable=isCancelable;
            return this;
        }

        /**
         * 设置是否可以取消
         * @param isCancelOutside
         * @return
         */
        public Builder setCancelOutside(boolean isCancelOutside){
            this.isCancelOutside=isCancelOutside;
            return this;
        }

        public LoadingDialog create(){
            if (mWeakReference != null) {
                LayoutInflater inflater = LayoutInflater.from(mWeakReference.get());
                View view = inflater.inflate(R.layout.dialog_loading_circle_rotate, null);
                LoadingDialog loadingDialog = new LoadingDialog(mWeakReference.get());
                loadingDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.tran_bg);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(loadingDialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                loadingDialog.setContentView(view);
                loadingDialog.setCancelable(isCancelable);
                loadingDialog.setCanceledOnTouchOutside(isCancelOutside);
                loadingDialog.getWindow().setAttributes(lp);
                return loadingDialog;
            } else {
                return null;
            }
        }

    }
}
