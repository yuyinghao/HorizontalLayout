#HorizontalLayout
主要针对Android TV，对子元素进行横向排列的Layout。
##焦点控制规则
Layout里面的第一个子元素会首先获取焦点，之后Layout里面的失去焦点后重新获取焦点的时候，还是原来那个失去焦点的子元素获得焦点。
##监听的事件
- 子元素焦点改变事件的监听
- 子元素点击事件的监听

-------------------
##支持滑动
layout的内容超过屏幕的话，会支持弹性滑动，滑动的原则是获取焦点的子元素尽量居中。
##展示效果
![Mou icon](https://github.com/yuyinghao/HorizontalLayout/blob/master/show.gif)
