<script setup lang="ts">
import {get,post,put} from "@/request/api.ts";
import {useUserStore} from "@/store/user.ts";

const router = useRouter()
const useUser = useUserStore()
const date1 = ref(['', ''])
const EventsForm = ref({
  uId: useUser.uId,
  title: '',
  cId: '',
  status: '',
  level: '',
  startDate:computed(()=>date1.value[0]),
  endDate:computed(()=>date1.value[1]),
  content: '',
})

const onSubmit = () => {
    post('/events', EventsForm.value)
       .then(() => {
            router.push('/Events')
        })
       .catch((err:any) => {
            console.log(err)
       })
}

const categories = ref([
  {
    cId: '',
    cName: '',
  },
]);

onMounted(() => {
  get('/eventCategories',{
    uId: useUser.uId,
  })
      .then((res:any) => {
        categories.value = res.valueOf();
      })
});
</script>

<template>
  <div style="width: 30%; border-radius: 10px;border: 1px solid #dcdfe6; padding: 20px; margin: 20px auto 0;" :style="{boxShadow: 'var(--el-box-shadow-lighter)'}" >
    <el-form :model="EventsForm" label-width="80px" label-position="top" id="form">
      <el-form-item label="事件名">
        <el-input v-model="EventsForm.title"/>
      </el-form-item>
      <el-form-item label="分类">
        <el-select v-model="EventsForm.cId" placeholder="选择分类">
          <el-option v-for="category in categories" :key="category.cId" :label="category.cName" :value="category.cId"/>
        </el-select>
      </el-form-item>
      <el-form-item label="状态">
        <el-radio-group v-model="EventsForm.status">
          <el-radio-button label="0">未完成</el-radio-button>
          <el-radio-button label="1">已完成</el-radio-button>
          <el-radio-button label="2">作废</el-radio-button>
        </el-radio-group>
      </el-form-item>
      <el-form-item  label="级别">
        <el-radio-group v-model="EventsForm.level">
          <el-radio-button label="0">重要</el-radio-button>
          <el-radio-button label="1">紧急</el-radio-button>
          <el-radio-button label="2">一般</el-radio-button>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="日期">
        <el-date-picker
            v-model="date1"
            type="daterange"
            range-separator="To"
            start-placeholder="Start date"
            end-placeholder="End date"
            value-format="YYYY-MM-DD"
        />
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" v-model="EventsForm.content"/>
      </el-form-item>
      <el-form-item>
        <el-button  type="primary" @click="onSubmit">提交</el-button>
        <el-button  type="default" @click="router.push('/Events')">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>

</style>
