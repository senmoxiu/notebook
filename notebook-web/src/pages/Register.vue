<script setup lang="ts">
import {post} from "../request/api.ts"

const user = reactive({
  uName: '',
  name: '',
  password: '',
  age: '',
  email: '',
  phone: '',
},)
const confirmPassword = ref('')
const resetForm = () => {
  user.uName = ''
  user.name = ''
  user.age = ''
  user.email = ''
  user.phone = ''
}
const router = useRouter()
const onSubmit = () => {
  console.log(user)
  if (user.password !== confirmPassword.value) {
    alert('两次密码输入不一致')
    return
  }else{
    post('/user',user)
        .then(res => {
          console.log(res)
          ElMessage.success('注册成功')
          router.push('/Login')
        })
        .catch(err => {
          console.log(err)
          ElMessage.error('请求失败')
         })

  }
}
const rules = {
  uName: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
  ],
  phone: [
    { required: false, message: '请输入手机号', trigger: 'blur' },
    { length:11, message: '请输入正确的手机号', trigger: 'blur' },
  ],
  email: [
    { required: false, message: '请输入邮箱', trigger: 'blur' },
    { type: 'email', message: '请输入正确的邮箱', trigger:['blur', 'change'] },
  ],
}
</script>

<template>
  <div style="width: 30%; margin:50px auto 0;border-radius: 10px;border: 1px solid #dcdfe6; padding: 20px; " :style="{boxShadow: 'var(--el-box-shadow-lighter)'}" >
    <el-form :model="user" label-width="80px" label-position="top" id="form" :rules="rules">
      <el-form-item label="用户名" prop="uName">
        <el-input v-model="user.uName"/>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="user.name"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="user.password"/>
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmPassword">
        <el-input type="password" v-model="confirmPassword"/>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model.number="user.age"/>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input v-model.number="user.phone"/>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="user.email"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>

</style>
