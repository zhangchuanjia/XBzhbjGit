##XBzhbj开始

> 这是跟着老师一点点敲的代码.
可能每一次自己敲代码的时候都会紧张,因为不自信能不能完成自己想要的逻辑,有时候想多学习点东西,觉得读的书多了自然就会懂了,太傻太天真,智商永远是硬伤有木有.但是智商可以变的,脑子是在生长的,我强迫自己记忆练习的时候,神经元在大量的生成,这就是智慧的开始,智慧是反映在物理世界的生物能量.
屁话说完,接下来就是每个小节都会有一段思路说明.所有的说明和信息都将通过纯文本的形式体现.

##Splash界面开始

1. 功能:这个界面承担着数据初始化工作,网络初始化工作,UI初始化工作.
2. 思路:首先搭建UI跳转逻辑完成即可,网络和数据初始化工作,放到后面.

##Guide界面

1. Splash完成后进入导航界面.

    . 功能:展示软件功能后跳到主界面,仅在初次启动应用时或者更新App后第一次启动时显示.
    . 思路:使用PreferenceUtil 和 Constent interface这种组合,存储完成标记boolean值.

2. 小红点的显示
    1. 使用代码动态添加NormalDot
    2. 使用ViewTreeObserver监听视图改变,用以在oncreat()方法中获得到控件的宽高值.
    3. 小红点的移动是通过不断增加marginleft的值来实现的.这种思维方式很巧秒,我的拙劣脑子只能先到动画.然后就乱了.

##主页集成开源框架SlidingMenu

导入库的过程有点小复杂,实际上是编译工具版本和构建工具版本经常出现不匹配导致的,因为AndroidStudio对各个工具的版本控制的挺严格.一帮严谨的程序员作出的东西,挺好的,计算机就要求细致严谨.面向对象思想虽然简化了我们编程的路径,但绝对不意味着编程思想也变得简单了.
老实团结在以CPU为中央的控制集团的周围做好你想让计算机 做好的事情.


##MainActivity中的两个Fragment

##ContentFragment的底部Tab的UI和逻辑

##ContentFragment的内容简单填充

1. 填充内容通过RadioGroup.添加RadioButton来实现底部的tab栏.
2. Radiobutton是通过button=@null(不显复选框) ;background=@null (外部可点击取消);drawabletop=图片res 来实现的显示效果.

##ContentFragment的内容Controller建立和抽取Controller基类

1. 新建了5个Controller这样分别来产生自己的填充View和初始化数据.
2. 新建的Controller构造方法里初始化view,并且提供getrootView的方法让其他类获得这个View.

**抽取基类**
1. 所有Controller的基类,用来定义Controller必须遵守的规则.
2. 两个抽象方法子类去自己实现,提供共有的返回view的方法.
3. 子类继承父类后直接在构造方法里寻找父类的构造,让父类的构造方法执行.

修改后正常运行.

##Controller的基类扩展TabController基类实现自带顶部title的效果.

##Tabcontroller内容填充依靠的MenuFragment思想.

