<script setup lang="ts">
import router from "@/router";
import {deleteRequest, get, post, put} from "@/request/api.ts";
import {useUserStore} from "@/store/user.ts";

const useUser = useUserStore();
const EventsCategories = ref([
  {cId:'', cName: ''}
]);

onMounted(() => {
  queryClassification();
});

const eventForm = ref({
  cId: '',
});

const numberOfEvents = ref(0);

const search=()=>{
  get('/events',eventForm)
      .then((res) => {
        numberOfEvents.value = res.length;
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
}

const queryClassification = () => {
  get('/eventCategories',{
    uId: useUser.uId,
  })
      .then((res: any) => {
        EventsCategories.value = res.valueOf();
      })
}

const handleAdd = () => {
  ElMessageBox.prompt('请输入新的分类名', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    inputPlaceholder: '请输入分类名',
    inputType: 'text',
    inputValue: '',
    beforeClose: (action, instance, done) => {
      if (action === 'confirm') {
        const cname = instance.inputValue;
        if (cname === '') {
          ElMessageBox.alert('分类名不能为空', '提示', {
            confirmButtonText: '确定',
          });
          done(0);
        } else {
          post('/eventCategories', {
            uId: useUser.uId,
            cName: cname,
          })
           .then((res) =>{
             ElMessage({message : '添加成功', type :'success'})
             console.log(res);
             queryClassification();
           })
           .catch((error) => {
             ElMessage('添加失败');
             console.error(error);
           })
          done();
        }
      } else {
        done();
      }
    },
  })
}
const handleBack = ()=>{
  router.push('/Events')
}

const handleEdit = (row: any)=>{
  ElMessageBox.prompt('请输入新的分类名', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    inputPlaceholder: '请输入分类名',
    inputType: 'text',
    inputValue: row.cName,
    beforeClose: (action, instance, done) => {
      if (action === 'confirm') {
        const cname = instance.inputValue;
        if (cname === '') {
          ElMessageBox.alert('分类名不能为空', '提示', {
            confirmButtonText: '确定',
          });
          done(0);
        } else {
          put('/eventCategories', {
            uId: useUser.uId,
            cId: row.cId,
            cName: cname,
          })
           .then((res) =>{
             ElMessage({message : '修改成功', type :'success'})
             queryClassification();
           })
           .catch((error) => {
             ElMessage('修改失败');
           })
          done();
        }
      } else {
        done();
      }
    },
  })
}


const handleDelete =(row: any)=>{
  console.log(row.cId);
  ElMessageBox.confirm('确认删除该分类吗？', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
    }).then(() => {
      search();
      if(EventsCategories.value.length !== 0){
        ElMessage({message : '删除失败,请先清空分类关联事件', type : 'error'});
      }else{
        deleteRequest('/eventCategories' ,{
          id: row.cId,
        })
            .then((res) =>{
              ElMessage({message : '删除成功', type :'success'})
              queryClassification();
            })
            .catch((error) => {
              ElMessage({message : '删除失败', type : 'error'});
              console.error(error);
            })
      }
    })
}


</script>

<template>
  <el-button type="primary" @click="handleAdd">新增分类</el-button>
  <el-button type="primary" @click="handleBack">返回</el-button>
  <el-table :data="EventsCategories" style="width: 100%">
    <el-table-column prop="cName" label="分类名" />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="success" @click="handleEdit(scope.row)">编辑</el-button>
        <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>

</style>
