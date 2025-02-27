import {createRouter,createWebHistory} from 'vue-router'
import Login from "../pages/Login.vue";
import Register from "../pages/Register.vue";
import Events from "../pages/Events.vue";
import EventsAdd from "../pages/EventsAdd.vue";
import EventsCategories from "../pages/EventsCategories.vue";
import EventsEdit from "../pages/EventsEdit.vue";
import {useUserStore} from "../store/user.ts";
import Main from "../pages/Main.vue";
const router = createRouter({
    history:createWebHistory(),
    routes:[
        {
            path:'/',
            redirect:'/Main',
            meta:{title:'欢迎'}
        },
        {
            path:'/Main',
            component:Main,
            meta:{title:'主页'}
        },
        {
            path:'/Login',
            component:Login,
            meta:{title:'登录'}
        },
        {
            path:'/Register',
            component:Register,
            meta:{title:'注册'}
        },
        {
            path:'/Events',
            component:Events,
            meta:{title:'事件'},
            children:[
                {
                    path:'Add',
                    component:EventsAdd,
                    meta:{title:'添加事件'}
                },
                {
                    path:'Category',
                    component:EventsCategories,
                    meta:{title:'分类'}
                },
                {
                    path:'Edit',
                    component:EventsEdit,
                    meta:{title:'编辑事件'}
                }
            ]

        },
    ]

})

export default router

router.beforeEach((to,_,next)=>{
    const userStore = useUserStore();
    if((to.path !== '/Login'&& to.path !== '/Register' && to.path !== '/Main') &&( userStore.uId===null||userStore.uId===undefined||userStore.uId==='') ){
        next('/Login')
    }else{
        next()
    }
})
