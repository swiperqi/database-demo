<template>
	<div>
		<input v-model="demoId" placeholder="请输入id" />
		<button @click="selectDemo">{{this.demoId == '' ? '查询全部' : '查询'}}</button>
		<table v-if="demoList.length > 0">
			<tr>
				<td>id</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>住址</td>
				<td>操作</td>
			</tr>
			<tr v-for="demo in demoList">
				<td>{{demo.id}}</td>
				<td><input v-model="demo.name" /></td>
				<td>
					<select v-model="demo.gender">
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
				<td><input v-model="demo.age" /></td>
				<td><input v-model="demo.address" /></td>
				<td>
					<button @click="updateDemo(demo.id, demo.name, demo.gender, demo.age, demo.address)">修改</button>
					<button @click="deleteById(demo.id)">删除</button>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input v-model="demoObject.name" /></td>
				<td>
					<select v-model="demoObject.gender">
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
				<td><input v-model="demoObject.age" /></td>
				<td><input v-model="demoObject.address" /></td>
				<td><button @click="insertDemo">添加</button></td>
			</tr>
		</table>
	</div>
</template>

<script>
	export default {
		name: 'databaseDemo',
		props: {
			demoId: {
				type: String,
				default: ''
			},
			demoList: {
				type: Array,
				default () {
					return []
				}
			},
			demoObject: {
				type: Object,
				default () {
					return {
						'id': '',
						'name': '',
						'gender': 1,
						'age': '',
						'address': ''
					}
				}
			}
		},
		methods: {
			selectDemo() {
				var that = this
				if (this.demoId == '') {
					this.$axios.get('/api/getAll')
						.then(function(result) {
							that.demoList = result.data
						}).catch(function(error) {
							console.log(error)
						})
				} else {
					this.$axios.get('/api/getById/' + that.demoId)
						.then(result => {
							var list = [result.data]
							that.demoList = list
						}).catch(error => {
							console.log(error)
						})
				}
			},
			deleteById(id) {
				var that = this
				this.$axios.delete('/api/deleteById/' + id)
					.then(result => {
						if (result.data) {
							that.selectDemo()
							window.alert('删除成功')
						} else {
							window.alert('删除失败')
						}
					}).catch(error => {
						console.log(error)
					})
			},
			insertDemo() {
				var that = this
				this.$axios.put('/api/insertDemo', that.demoObject)
					.then(result => {
						if (result.data) {
							that.selectDemo()
							window.alert('添加成功')
						} else {
							window.alert('添加失败')
						}
					}).catch(error => {
						console.log(error)
					})
				this.demoObject = {
					'id': '',
					'name': '',
					'gender': 1,
					'age': '',
					'address': ''
				}
			},
			updateDemo(id, name, gender, age, address) {
				var demo = {
					'id': id,
					'name': name,
					'gender': gender,
					'age': age,
					'address': address
				}
				var that = this
				this.$axios.post('/api/updateDemo', demo)
					.then(result => {
						if (result.data) {
							that.selectDemo()
							window.alert('修改成功')
						} else {
							window.alert('修改失败')
						}
					}).catch(error => {
						console.log(error)
					})
			}
		}
	}
</script>

<style>
</style>
