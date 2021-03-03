// the interface of IPC
package com.module.demo.binder;

import com.module.demo.binder.BinderMessage;

interface IRemoteService {
    int getPid();
    BinderMessage getBinderMessage();
}