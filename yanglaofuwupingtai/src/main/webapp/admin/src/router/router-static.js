import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import bingli from '@/views/modules/bingli/list'
    import dictionary from '@/views/modules/dictionary/list'
    import huli from '@/views/modules/huli/list'
    import jiaofei from '@/views/modules/jiaofei/list'
    import laifangdengji from '@/views/modules/laifangdengji/list'
    import news from '@/views/modules/news/list'
    import richenganpai from '@/views/modules/richenganpai/list'
    import xinlitiaohu from '@/views/modules/xinlitiaohu/list'
    import yisheng from '@/views/modules/yisheng/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuangong from '@/views/modules/yuangong/list'
    import yuyueguahao from '@/views/modules/yuyueguahao/list'
    import zhongyao from '@/views/modules/zhongyao/list'
    import zhongyaoChuruInout from '@/views/modules/zhongyaoChuruInout/list'
    import zhongyaoChuruInoutList from '@/views/modules/zhongyaoChuruInoutList/list'
    import zhongyizhenduan from '@/views/modules/zhongyizhenduan/list'
    import zongyishiliao from '@/views/modules/zongyishiliao/list'
    import config from '@/views/modules/config/list'
    import dictionaryKeshi from '@/views/modules/dictionaryKeshi/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXinlitiaohu from '@/views/modules/dictionaryXinlitiaohu/list'
    import dictionaryZhongyaoChuruInout from '@/views/modules/dictionaryZhongyaoChuruInout/list'
    import dictionaryZongyishiliao from '@/views/modules/dictionaryZongyishiliao/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryKeshi',
        name: '科室',
        component: dictionaryKeshi
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXinlitiaohu',
        name: '心里调护类型',
        component: dictionaryXinlitiaohu
    }
    ,{
        path: '/dictionaryZhongyaoChuruInout',
        name: '出入库类型',
        component: dictionaryZhongyaoChuruInout
    }
    ,{
        path: '/dictionaryZongyishiliao',
        name: '食疗类型',
        component: dictionaryZongyishiliao
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/bingli',
        name: '病例',
        component: bingli
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/huli',
        name: '护理',
        component: huli
      }
    ,{
        path: '/jiaofei',
        name: '缴费信息',
        component: jiaofei
      }
    ,{
        path: '/laifangdengji',
        name: '来访登记',
        component: laifangdengji
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/richenganpai',
        name: '日程安排',
        component: richenganpai
      }
    ,{
        path: '/xinlitiaohu',
        name: '心里调护',
        component: xinlitiaohu
      }
    ,{
        path: '/yisheng',
        name: '医生',
        component: yisheng
      }
    ,{
        path: '/yonghu',
        name: '老人',
        component: yonghu
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }
    ,{
        path: '/yuyueguahao',
        name: '预约挂号',
        component: yuyueguahao
      }
    ,{
        path: '/zhongyao',
        name: '中药信息',
        component: zhongyao
      }
    ,{
        path: '/zhongyaoChuruInout',
        name: '出入库',
        component: zhongyaoChuruInout
      }
    ,{
        path: '/zhongyaoChuruInoutList',
        name: '出入库详情',
        component: zhongyaoChuruInoutList
      }
    ,{
        path: '/zhongyizhenduan',
        name: '中医诊断',
        component: zhongyizhenduan
      }
    ,{
        path: '/zongyishiliao',
        name: '中医食疗',
        component: zongyishiliao
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
