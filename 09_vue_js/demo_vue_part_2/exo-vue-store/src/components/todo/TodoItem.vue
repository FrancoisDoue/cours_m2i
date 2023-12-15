<script setup>
import { useTodoListStore } from '@/stores/todoListStore'
import { computed } from 'vue';

const thisTodo = useTodoListStore()

const props = defineProps(
    {todo: Object, required: true}
)

let favClass = computed(() => `btn ${props.todo.isFavourite ? 'btn-outline-danger' : 'btn-outline-secondary'}`)

const toggleFavourite = () => {
    props.todo.isFavourite = !props.todo.isFavourite
}

</script>

<template>
    <div class="card w-25 my-2 shadow-sm">
        <div class="card-body d-flex justify-content-between align-items-center">
            <p class="card-text text-bold fw-bolder">
                {{ props.todo.todoText }}
            </p>
            <div>
                <button @click="thisTodo.removeTodo(props.todo.id)" class="btn btn-outline-secondary me-1">
                    <i class="bi bi-trash-fill"></i>
                </button>
                
                <button @click="toggleFavourite" :class="favClass">
                    <i class="bi bi-heart-fill"></i>
                </button>
            </div>
        </div>
    </div>
</template>