package com.example.login.adapter;


import com.example.login.R;
import com.example.login.model.RegisterCompanyEntity;
import com.example.networkrequest.utils.RecyclerViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

public class ChooseCompanyAdapter extends BaseQuickAdapter<RegisterCompanyEntity, RecyclerViewHolder> {

    public ChooseCompanyAdapter(List<RegisterCompanyEntity> entityList) {
        super(R.layout.item_recyclerview_choose_company, entityList);

    }

    @Override
    protected void convert(RecyclerViewHolder helper, RegisterCompanyEntity item) {
        helper.setText(R.id.choose_company_tv_name,item.getCompany_name());
    }
}
