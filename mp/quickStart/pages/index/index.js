//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    name: 1,
    array: [{ msg: '这是一个大帅比' }, { msg: '2' }],
    userInfo: {},
    flag: false,
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    staffA: { firstName: 'Hulk', lastName: 'Hu' },
    staffB: { firstName: 'Shang', lastName: 'You' },
    staffC: { firstName: 'Gideon', lastName: 'Lin' }
  },
  //事件处理函数
  bindViewTap: function() {
    // console.log("bindViewTap")
    wx.navigateTo({
      // 当tabbar定义了相同的跳转地址在页面中不要再定义相同的链接了
      url: '../logs/logs',
      complete: function (res) {
        console.log(res)
      }  
    })
  },
  dashuaibi: function(e) {
    this.setData({
      flag: this.data.flag == false ? true : false
    })
  },
  changeName: function (e) {
    // sent data change to view.
    this.setData({
      name: this.data.name +1
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  onPullDownRefresh: function() {
    console.log("console log  pullDown ：" + this.route)
  }

})
