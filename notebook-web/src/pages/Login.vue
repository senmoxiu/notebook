<script setup lang="ts">
import {get,put,post,deleteRequest} from "../request/api.ts"
import {useUserStore} from "../store/user.ts";
const router = useRouter()
const loginForm = reactive({
  uName: '',
  password: '',
},)
const onRegister = () => {
  router.push('/Register')
}
const onSubmit = () => {
  if (loginForm.uName === '' || loginForm.password === '') {
    ElMessage({
      message: '用户名或密码不能为空',
      type: 'warning'
    })
    return
  }
  else{
    get('/user',loginForm)
        .then(res => {
          console.log(res)
          if(res.length === 0){
            ElMessage.error('用户名或密码错误')
          }else{
            const userStore = useUserStore()
            //token不会怎么用，先存一下uid
            userStore.uId = res[0].uId
            userStore.uName = res[0].uName
            router.push('/Events')
          }
        })
        .catch(err => {
          console.log(err)
          ElMessage.error('请求失败')
        })

  }
}
</script>

<template>
  <div style="width: 30%; margin:50px auto 0;;border-radius: 10px;border: 1px solid #dcdfe6; padding: 20px; " :style="{boxShadow: 'var(--el-box-shadow-lighter)'}" >
    <el-form :model="loginForm" label-width="80px" label-position="top" id="form">
      <el-form-item label="用户名">
        <el-input v-model="loginForm.uName"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="loginForm.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="onRegister">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>

</style>
