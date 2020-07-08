const app = new Vue({
    el:'#app',
    data:{
        books:[
            {
                id: 1,
                name: '《算法导论》',
                date: '2006-9',
                price: 85.00,
                count: 1
            },
            {
                id: 2,
                name: '《UNIX编程艺术》',
                date: '2006-2',
                price: 59.00,
                count: 1
            },
            {
                id: 3,
                name: '《编程珠玑》',
                date: '2008-10',
                price: 39.00,
                count: 1
            },
            {
                id: 4,
                name: '《代码大全》',
                date: '2006-3',
                price: 128.00,
                count: 1
            }
        ]
    },
    //设置保留两位小数
    methods:{
        getFinalPrice(price){
            return '￥'+ price.toFixed(2);
        },
        decrement(index){
            // this.books[index].count >1?this.books[index].count--:this.books[index].count=1;
            this.books[index].count--;
        },
        increment(index){
            this.books[index].count++;
        },
        removeHandle(index){
            this.books.splice(index,1)
        }
    },
    computed:{
        totalPrice(){
            //1. 普通的for循环
            // let result = 0;
            // for(let i =0; i < this.books.length;i++){
            //      result += this.books[i].price * this.books[i].count;
            // }
            // return result;
            //2. ES6新语法

            // let result = 0;
            // for (let i in this.books){
            //     result += this.books[i].price * this.books[i].count;
            // }
            // return result;


            //3.
                let result = 0;
                for (let item of this.books){
                    result += item.price * item.count;
                }
                return result;
        }
    },
//    使用过滤器的方式解决小数点
    filters:{
        showPrice(price){
            return '￥'+ price.toFixed(2);
        }
    }
})

// 编程范式:命令式编程/声明式编程->从写代码方式分类的
// 编程范式:面向对象编程(第一公民)/函数式编程(第一公民:函数)
//filter/map/reduce
const nums = [10,20,111,222,334,30,40,50]
//1. 高阶函数

// filter中的回调函数有一个要求,必须返回一个boolean值
//当返回true时,函数内部会自动将这次回调的n加入新的数组中,
//当返回false时,函数内部会过滤掉这次的n
// let newNums = nums.filter(function (n) {
//     return n<100?true:false;
// })
// console.log(newNums)


//2. 原始做法
// const nums = [10,20,111,222,334,30,40,50]
// // 从nums中取出所有小于100的数字,
// let newNums = []
// for (let n of nums){
//     if (n<100){
//         newNums.push(n);
//     }
// }
//
// //2. 将所有小于100的数字进行转化:全部*2
// let new2nNums = []
// for(let n of newNums){
//     new2nNums.push(n*2)
// }
//
// //3. 将所有new2nNums中数字相加,得到最终结果
// let totalNums = 0;
// for (let n of new2nNums){
//     totalNums+=n;
// }
