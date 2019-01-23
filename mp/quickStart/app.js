//app.js
App({
    onLaunch: function() {
        // 展示本地存储能力
        var logs = wx.getStorageSync('logs') || []
        logs.unshift(Date.now())
        wx.setStorageSync('logs', logs)

        // 登录
        wx.login({
            success: res => {
                // 发送 res.code 到后台换取 openId, sessionKey, unionId
                //secret: 8363dcb94c6e0ac918927383475eb82a
                if (res.code) {
                    // 发起网络请求
                    wx.request({
                        url: 'https://incola.serveo.net/wx/onLogin',
                        data: {
                            code: res.code
                        },
                        success(response) {
                            console.log(response.data)
                        }
                    })
                } else {
                    console.log('登录失败！' + res.errMsg)
                }
            }
        })

        wx.openSetting({
            success(res) {
                console.log(res.authSetting)
                // res.authSetting = {
                //   "scope.userInfo": true,
                //   "scope.userLocation": true
                // }
            }
        })
        // 获取用户信息
        wx.getSetting({
            success: res => {
                if (res.authSetting['scope.userInfo']) {
                    // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
                    wx.getUserInfo({
                        success: res => {
                            // 可以将 res 发送给后台解码出 unionId
                            this.globalData.userInfo = res.userInfo

                            // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                            // 所以此处加入 callback 以防止这种情况
                            if (this.userInfoReadyCallback) {
                                this.userInfoReadyCallback(res)
                            }
                        }
                    })
                }
            }
        })
    },
    onShow: function(options) {
        console.log("console log : onShow");
    },
    onHide: function() {
        console.log("console log : onHide");
    },
    onError: function(msg) {
        console.log(msg)
    },
    globalData: {
        userInfo: null
    }
})