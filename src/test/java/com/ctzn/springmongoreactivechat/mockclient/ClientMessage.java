package com.ctzn.springmongoreactivechat.mockclient;

import lombok.Value;

@Value
class ClientMessage {
    int frameId;
    User user;
    String type;
    String payload;
}
