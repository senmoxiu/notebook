<script setup lang="ts">
import {Delete, Edit} from "@element-plus/icons-vue";
import {get,deleteRequest} from "../request/api.ts"
import {useUserStore} from "../store/user.ts";
import {useStoreEvent} from "@/store/event.ts";

const router = useRouter();
const useUser = useUserStore();
const eventForm = reactive({uId: useUser.uId,title: '', cId: '', status: '', level: ''});
const events = ref([
  {
    eId: '',
    cId: '',
    title: '',
    content: '',
    startDate:'',
    endDate: '',
    level: 0,
    status: 0,
  },
]);
const categories = ref([
  {
    cId: '',
    cName: '',
  },
]);
const activeNames = '事件列表'

//初始化数据
onMounted(() => {
  search();
  queryClassification();
});


const queryClassification = () => {
  get('/eventCategories',{
    uId: useUser.uId,
  })
      .then((res: any) => {
        categories.value = res.valueOf();
      })
}


router.afterEach((to, from) => {
  // 检查是否从 /Events/Add、/Events/Category 或 /Events/Edit 返回到 /Events
  if (
    (from.path === '/Events/Add' || from.path === '/Events/Category' || from.path === '/Events/Edit') &&
    to.path === '/Events'
  ) {
    search();
    queryClassification();
  }
});


//页面跳转
const addEvent=()=>{
  router.push('/Events/Add');
}
const addCategory=()=>{
  router.push('/Events/Category');
}


//查询
const search=()=>{
  get('/events',eventForm)
   .then((res) => {
     events.value = res.valueOf();
    })
   .catch((err) => {
      console.log(err);
   });
}

const deleteEvent=(event:any)=>{
  deleteRequest('/events',{
    id: event.eId,
  })
   .then((res) => {
      console.log(res);
      search();
    })
   .catch((err) => {
      console.log(err);
    });
}

const editEvent=(event:any)=>{
  const useEvent = useStoreEvent()
  useEvent.eId = event.eId;
  useEvent.title = event.title;
  useEvent.cId = event.cId;
  useEvent.status = event.status;
  useEvent.level = event.level;
  useEvent.startDate = event.startDate;
  useEvent.endDate = event.endDate;
  useEvent.content = event.content;
  console.log(useEvent);
  router.push('/Events/Edit')
}

const reset=()=>{
  eventForm.title = '';
  eventForm.cId = '';
  eventForm.status = '';
  eventForm.level = '';
  search();
}

//时间戳转换
const formatDate=(timestamp:string)=>{
  const date = new Date(timestamp);
  return date.toLocaleDateString();
}
</script>

<template>
  <el-container style="height: 100%;">
    <el-aside style="background-color: rgb(242.5, 208.5, 157.5); padding: 20px;" h="100%">
          <el-form :model="eventForm">
            <el-form-item label="事件名">
              <el-input v-model="eventForm.title"/>
            </el-form-item>
            <el-form-item label="分类">
              <el-select v-model="eventForm.cId" placeholder="选择分类">
                <el-option v-for="category in categories" :key="category.cId" :label="category.cName" :value="category.cId"/>
              </el-select>
            </el-form-item>
            <el-form-item label="状态">
              <el-select v-model="eventForm.status" placeholder="选择状态">
                <el-option label="未完成" value="0"></el-option>
                <el-option label="已完成" value="1"></el-option>
                <el-option label="作废" value="2"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item  label="级别">
              <el-select v-model="eventForm.level" placeholder="选择级别">
                <el-option label="重要" value="0"></el-option>
                <el-option label="紧急" value="1"></el-option>
                <el-option label="一般" value="2"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="search">查询</el-button>
              <el-button type="default" @click="reset">重置</el-button>
            </el-form-item>
          </el-form>
    </el-aside>
    <el-main>

      <div v-if="router.currentRoute.value.path === '/Events/Add' || router.currentRoute.value.path === '/Events/Category' || router.currentRoute.value.path === '/Events/Edit'">
        <RouterView/>
      </div>
      <div v-else>
        <el-button type="primary" @click="addEvent">新增事件</el-button>
        <el-button type="primary" @click="addCategory">编辑事件分类</el-button>
        <el-divider/>
        <h2>事件列表</h2>
        <el-scrollbar :native="false">
          <el-collapse v-model="activeNames" accordion>
            <el-collapse-item v-for="event in events" :key="event.eId" :name="event.eId">
              <template #title>
                <el-text v-if="event.status === 2" type="info" style="color:rgb(232.8, 233.4, 234.6);">
                  {{ event.title }}
                </el-text>
                <el-text v-else-if="event.status === 1" tag="del">
                  {{ event.title }}
                </el-text>
                <el-text v-else :type="event.level === 0 ? 'warning' : event.level === 1 ? 'danger' :''">
                  {{ event.title }}
                </el-text>
              </template>
              <div>
                <el-button type="primary" :icon="Edit" @click="editEvent(event)" round>编辑</el-button>
                <el-button type="danger" :icon="Delete" @click="deleteEvent(event)" round>删除</el-button>
              </div>
              <div>
                {{formatDate(event.startDate)}} - {{formatDate(event.endDate)}}
              </div>
              <div>
                {{event.content}}
              </div>
            </el-collapse-item>
          </el-collapse>
        </el-scrollbar>
      </div>
    </el-main>
  </el-container>
</template>

<style scoped>


</style>
