package com.example.classes

/*  Project 1:Create (Task) data class that holds these values: id, name, note and
    isCompleted has default value of false. Then create (Todo) class that do the following:
    -Show all the tasks (Method)
    -Print specific task, One parameter of type Int (Print by ID?)
    -Add task, Parameter of type Task (Method)
    -Remove task, Parameter of type task (Method)
    -Change task, Parameter of type Task (Method)
    The Class has an array property called tasks of type (Task) which has a private set.
 */

fun main(){
 var toDo:ToDo  = ToDo()
 var task1 = Task(1, "John", "Clean the kitchen")
 var task2 = Task(11, "Ahmed", "Change the tyres", true)
 var task3 = Task(192, "Mohammad","Change the batteries", isCompleted = true)
 var task4 = Task(300, "Saeed", "Throw the trash")

 toDo.addTask(task1)
 toDo.addTask(task2)
 toDo.addTask(task3)
 toDo.addTask(task4)
 toDo.printTask(task3.id)
 toDo.printTask(task4.id)
 toDo.removeTask(task3)
 toDo.removeTask(task2)
 toDo.removeTask(task1)
 toDo.changeTask(task4)
 toDo.printAllTasks()
}

//Does not need brackets () as we will not pass variables through this class
class ToDo{
    var tasks = arrayListOf<Task>()
    private set

    fun printTask(id: Int){
        for(i in tasks){
            if(i.id==id){
                println("Printing task is: $i") //No break, as the ID's are currently not unique
            }else println("There is no task with the id: $id")
        }
    }
    fun addTask(task: Task) {
        tasks.add(task)
        println("$task has been added")
    }

    fun removeTask(task: Task){
        if(tasks.isNotEmpty()){
            if(task in tasks) { // this is the same as tasks.contain(task)
                tasks.remove(task)
                println("$task has been removed")
            }else println("Task does not exist")
        }else println("There are no tasks")
    }
    fun changeTask(task: Task){
        if(tasks.isNotEmpty()){
            if(task in tasks) { // this is the same as tasks.contain(task)
                task.isCompleted = !task.isCompleted
                println("$task isCompleted has been changed to ${task.isCompleted}")
            }else println("Task does not exist")
        }else println("There are no tasks")
    }
    fun printAllTasks(){
        for(i in tasks) println("The available tasks are:\n  $i")
    }
}

//Some variables are val because they SHOULDN'T be changed, in this assignment only isCompleted is var
data class Task(val id: Int,
                val name: String,
                val note: String,
                var isCompleted: Boolean = false)