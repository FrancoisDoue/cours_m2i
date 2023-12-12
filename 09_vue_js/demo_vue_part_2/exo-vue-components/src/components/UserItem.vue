<script setup>
import { ref } from 'vue';
import {REG_MAIL} from '../utilities/constants.js'

const props = defineProps({
  user: {type: Object, required: true}
})
const emit = defineEmits(['edit-user','delete-user'])
let userName = ref(props.user.username)
let userMail = ref(props.user.usermail)
let isEdit = ref(false);

const editUser = () => {
  if (userName.value && userMail.value){
    emit('edit-user', {id: props.user.id, username: userName.value, usermail: userMail.value});
  }
  isEdit.value = false;
}

</script>

<template>
  <tr v-if="!isEdit">
    <td>{{props.user.username}}</td>
    <td>{{props.user.usermail}}</td>
    <td>
      <button class="btn btn-warning px-4" @click="() => isEdit = true">Edit</button>
    </td>
    <td>
      <button class="btn btn-danger" @click="$emit('delete-user', user.id)">Delete</button>
    </td>
  </tr>
  <tr v-else>
    <td><input type="text" class="form-control bg-dark text-light" v-model="userName"></td>
    <td><input type="text" class="form-control bg-dark text-light" v-model="userMail"></td>
    <td>
      <button class="btn btn-primary px-4" @click="editUser">Save</button>
    </td>
    <td>
      <button class="btn btn-secondary" @click="() => isEdit = false">Cancel</button>
    </td>

  </tr>

</template>

<style scoped>

</style>
