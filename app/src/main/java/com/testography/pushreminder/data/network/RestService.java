package com.testography.pushreminder.data.network;

import com.testography.pushreminder.utils.ConstantsManager;

import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

public interface RestService {
    @GET("info")
    Observable<NotificationRes> getNotificationResObs
            (@Header(ConstantsManager.IF_MODIFIED_SINCE_HEADER)
                String lastEntityUpdate);
}
