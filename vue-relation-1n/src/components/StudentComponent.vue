<template>
    <a-table :columns="columns" :data-source="data" @resizeColumn="handleResizeColumn">
        <template #headerCell="{ column }">
            <template v-if="column.key === 'name'">
                <span>
                    <smile-outlined />
                    Name
                </span>
            </template>
        </template>

        <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'name'">
                <a>
                    {{ record.name }}
                </a>
            </template>
            <template v-else-if="column.key === 'action'">
                <span>
                    <a-button type="text" :style="{ color: 'hsla(160, 100%, 37%)' }">
                        <edit-filled />
                        Select
                    </a-button>
                    <a-divider type="vertical" />
                    <a-button type="text" :style="{ color: 'red' }">
                        <delete-filled />
                        Delete
                    </a-button>
                </span>
            </template>
        </template>
    </a-table>
</template>
<script lang="ts">
import { SmileOutlined, DownOutlined, DeleteFilled, EditFilled } from '@ant-design/icons-vue';
import type { TableColumnsType } from 'ant-design-vue';
import { defineComponent, ref } from 'vue';

const data = [
    {
        key: '1',
        name: 'John Brown',
        age: 32,
        address: 'New York No. 1 Lake Park'
    },
    {
        key: '2',
        name: 'Jim Green',
        age: 42,
        address: 'London No. 1 Lake Park',
        tags: ['loser'],
    },
    {
        key: '3',
        name: 'Joe Black',
        age: 32,
        address: 'Sidney No. 1 Lake Park',
        tags: ['cool', 'teacher'],
    },
];

export default defineComponent({
    components: {
        SmileOutlined,
        DownOutlined,
        DeleteFilled,
        EditFilled
    },
    setup() {
        const columns = ref<TableColumnsType>([
            {
                dataIndex: 'name',
                key: 'name',
                resizable: true,
                width: 150,
            },
            {
                title: 'Age',
                dataIndex: 'age',
                key: 'age',
                resizable: true,
                width: 100,
                minWidth: 100,
                maxWidth: 200,
            },
            {
                title: 'Address',
                dataIndex: 'address',
                key: 'address',
            },
            {
                title: 'Action',
                key: 'action',
            },
        ]);
        return {
            data,
            columns,
            handleResizeColumn: (w, col) => {
                col.width = w;
            },
        };
    },
});
</script>


<!-- <template>
    <div class="my-component">
        <div>{{ message }}</div>
        <div><button @click="changeMessage">Click me</button></div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            message: 'This is my first component using binding data'
        }
    },
    methods: {
        changeMessage() {
            this.message = 'this is new message'
        }
    },
    watch: {
        message() {
            console.log('message changed')
        }
    }
}
</script>

<style lang="scss" scoped>
</style> -->