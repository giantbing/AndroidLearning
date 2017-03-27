package com.example.giant.rxandroidlearning.Dagger.compoents;

import com.example.giant.rxandroidlearning.view.Impl.LoginActivity;

import dagger.Component;

/**@author giant
 * Created by giant on 2017/3/27.
 */
@Component
public interface MainCompoent {
    /**
     * 需要用到这个连接器的对象，就是这个对象里面有需要注入的属性
     * （被标记为@Inject的属性）
     * 这里inject表示注入的意思，这个方法名可以随意更改，但建议就
     * 用inject即可。
     */
    void inject(LoginActivity activity);
}
