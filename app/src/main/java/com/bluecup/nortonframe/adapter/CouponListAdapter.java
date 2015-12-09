package com.bluecup.nortonframe.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluecup.model.CouponBO;
import com.bluecup.nortonframe.R;
import com.bluecup.nortonframe.utils.CouponPriceUtil;

/**
 * 券票列表 adapter
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public class CouponListAdapter extends NBaseAdapter<CouponBO> {

    public CouponListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_coupon, viewGroup, false);
            holder = new ViewHolder();
            holder.titleText = (TextView) convertView.findViewById(R.id.text_item_title);
            holder.infoText = (TextView) convertView.findViewById(R.id.text_item_info);
            holder.priceText = (TextView) convertView.findViewById(R.id.text_item_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initDatas(holder, position);
        return convertView;
    }

    private void initDatas(ViewHolder holder, int position) {
        CouponBO coupon = itemList.get(position);
        holder.titleText.setText(coupon.getName());
        holder.infoText.setText(coupon.getIntroduce());
        SpannableString priceString;
        // 根据不同的券类型展示不同的价格显示方式
        switch (coupon.getModelType()) {
            default:
            case CouponBO.TYPE_CASH:
                priceString = CouponPriceUtil.getCashPrice(context, coupon.getFaceValue(), coupon.getEstimateAmount());
                break;
            case CouponBO.TYPE_DEBIT:
                priceString = CouponPriceUtil.getVoucherPrice(context, coupon.getDebitAmount(), coupon.getMiniAmount());
                break;
            case CouponBO.TYPE_DISCOUNT:
                priceString = CouponPriceUtil.getDiscountPrice(context, coupon.getDiscount(), coupon.getMiniAmount());
                break;
        }
        holder.priceText.setText(priceString);
    }

    static class ViewHolder {
        TextView titleText;
        TextView infoText;
        TextView priceText;
    }
}
