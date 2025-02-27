<script setup lang="ts">

import { createPinia } from 'pinia'
import {useUserStore} from "./store/user.ts";
import App from './App.vue'
const pinia = createPinia()
const app = createApp(App)
app.use(pinia)

const router = useRouter()

const exit = () => {

  useUser.uId = ''
  useUser.uName = ''
  router.push('/')
}
const useUser = useUserStore()
</script>

<template>
  <el-container style="height: 100vh">
    <el-header style="height: auto; padding: 0;">
<!--      菜单激活状态不能在路由切换时实时更新，需要后续优化-->
      <el-menu :ellipsis="false" background-color="#E6A23C" text-color="#fff" active-text-color="rgb(247.5, 227.1, 196.5)" mode="horizontal" router>
        <el-menu-item index="/">
          <el-image class="logo" src="https://patchwiki.biligame.com/images/zspms/1/1e/gj7bt8yx5h3h7vyetwvgg8grlxggq4i.png" fit="cover" />
        </el-menu-item>
        <el-menu-item v-if="useUser.uId" @click="exit">退出</el-menu-item>
        <el-menu-item index="Login" v-else >登录</el-menu-item>

      </el-menu>
    </el-header>
    <el-main style="padding: 0;">
      <RouterView/>
    </el-main>
  </el-container>
</template>

<style scoped>
.el-menu--horizontal > .el-menu-item:nth-child(1) {
  margin-right: auto;
}
.logo {
  width: 55px; height: 55px;
}
</style>
