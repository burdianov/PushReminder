package com.testography.pushreminder.ui;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.testography.pushreminder.R;
import com.testography.pushreminder.data.storage.dto.NotificationDto;
import com.testography.pushreminder.utils.ConstantsManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    private List<NotificationDto> mNotificationsList = new ArrayList<>();

    public void addItem(NotificationDto notificationDto) {
        mNotificationsList.add(notificationDto);
        notifyDataSetChanged();
    }

    @Override
    public NotificationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notification, parent, false);
        return new NotificationsViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(NotificationsViewHolder holder, int position) {
        NotificationDto notification = mNotificationsList.get(position);
        holder.titleTxt.setText(notification.getTitle());
        try {
            holder.dateTxt.setText(elapsedTime(notification.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.contentTxt.setText(notification.getContent());
    }

    @Override
    public int getItemCount() {
        return mNotificationsList.size();
    }

    private String elapsedTime(String dateString) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat(
                ConstantsManager.SERVER_DATE_FORMAT, Locale.US);
        Date commentDate = timeFormat.parse(dateString);
        long commentTime = commentDate.getTime();

        return DateUtils.getRelativeTimeSpanString(commentTime).toString();
    }

    public void reloadAdapter(List<NotificationDto> notificationDtos) {
        mNotificationsList.clear();
        mNotificationsList = notificationDtos;
        notifyDataSetChanged();
    }

    public class NotificationsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_txt)
        TextView titleTxt;
        @BindView(R.id.date_txt)
        TextView dateTxt;
        @BindView(R.id.content_txt)
        TextView contentTxt;

        public NotificationsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
