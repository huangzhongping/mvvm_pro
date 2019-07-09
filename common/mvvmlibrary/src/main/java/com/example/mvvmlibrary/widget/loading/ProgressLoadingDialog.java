package com.example.mvvmlibrary.widget.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.mvvmlibrary.R;


public class ProgressLoadingDialog extends Dialog {


    public ProgressLoadingDialog(Context context) {
        super(context);
    }

    public ProgressLoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder{

        private Context context;
        private String message;
        private boolean isCancelable=false;
        private boolean isCancelOutside=false;


        public Builder(Context context) {
            this.context = context;
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

        public ProgressLoadingDialog create(){

            LayoutInflater inflater = LayoutInflater.from(context);
            View view=inflater.inflate(R.layout.dialog_loading,null);
            ProgressLoadingDialog loadingDailog=new ProgressLoadingDialog(context, R.style.MyDialogStyle);
            loadingDailog.setContentView(view);
            loadingDailog.setCancelable(isCancelable);
            loadingDailog.setCanceledOnTouchOutside(isCancelOutside);
            return  loadingDailog;

        }


    }
}