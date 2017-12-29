# ratpack-errorhandler-example
[![Build Status](https://travis-ci.org/gregwhitaker/ratpack-errorhandler-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/ratpack-errorhandler-example)

An example of using a global error handler in [Ratpack](http://www.ratpack.io).

This example starts a simple service for querying user data with a couple built-in error conditions to show you how exceptions are raised and handled by the global error handler.

## Running the Example
1. Start the example by running the following Gradle command:

        $ ./gradlew run

2. Query the list of all active users in the system using the following command:

        $ curl http://localhost:5050/users

    You should see the following in the console:
    
        {
           "users":[
              {
                 "username":"bob",
                 "active":true
              },
              {
                 "username":"alice",
                 "active":true
              },
              {
                 "username":"john",
                 "active":true
              }
           ]
        }

3. Trigger a field-level error, by supplying a bad query parameter, using the following command:

        $ curl http://localhost:5050/users?active=badvalue
        
    You should see something similar to the following in the console:
    
        {
           "id":"cee209b7-8521-4137-9a69-e6e3a8db4461",
           "status":400,
           "statusMessage":"Bad Request",
           "errorCode":"4321",
           "errorMessage":"Validation Exception",
           "fieldErrors":[
              {
                 "field":"active",
                 "errorCode":"4321-1",
                 "errorMessage":"Value must be either 'true' or 'false'."
              }
           ],
           "stacktrace":"com.github.gregwhitaker.ratpackerrorhandler.example.core.error.UnsupportedActiveFlagException\n\tat com.github.gregwhitaker.ratpackerrorhandler.example.api.user.ListUsersHandler.handle(ListUsersHandler.java:24)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.handling.internal.MethodHandler.handle(MethodHandler.java:44)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.handling.internal.DefaultContext.insert(DefaultContext.java:179)\n\tat ratpack.path.internal.PathHandler.handle(PathHandler.java:61)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.handling.internal.DefaultContext.lambda$start$4(DefaultContext.java:104)\n\tat ratpack.exec.internal.DefaultExecution.lambda$new$0(DefaultExecution.java:79)\n\tat ratpack.exec.internal.DefaultExecution$InitialExecStream.exec(DefaultExecution.java:361)\n\tat ratpack.exec.internal.DefaultExecution.exec(DefaultExecution.java:196)\n\tat ratpack.exec.internal.DefaultExecution.intercept(DefaultExecution.java:189)\n\tat ratpack.exec.internal.DefaultExecution.drain(DefaultExecution.java:169)\n\tat ratpack.exec.internal.DefaultExecution.<init>(DefaultExecution.java:93)\n\tat ratpack.exec.internal.DefaultExecController$1.lambda$start$0(DefaultExecController.java:195)\n\tat io.netty.util.concurrent.PromiseTask.run(PromiseTask.java:73)\n\tat io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:163)\n\tat io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:403)\n\tat io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:442)\n\tat io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:858)\n\tat ratpack.exec.internal.DefaultExecController$ExecControllerBindingThreadFactory.lambda$newThread$0(DefaultExecController.java:136)\n\tat io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)\n\tat java.lang.Thread.run(Thread.java:745)\n"
        }

4. Trigger an error by querying for a non-existent user, using the following command:

        $ curl http://localhost:5050/users/jim
        
    You should see something similar to the following in the console:
    
        {
           "id":"fb4a6fb0-1390-4b62-bd6f-6f4ecb7ffa83",
           "status":404,
           "statusMessage":"Not Found",
           "errorCode":"5678",
           "errorMessage":"NoSuchUserException",
           "errorDetail":"User 'jim' does not exist!",
           "stacktrace":"com.github.gregwhitaker.ratpackerrorhandler.example.core.error.NoSuchUserException\n\tat com.github.gregwhitaker.ratpackerrorhandler.example.services.user.UserService.findOne(UserService.java:43)\n\tat com.github.gregwhitaker.ratpackerrorhandler.example.api.user.GetUserHandler.handle(GetUserHandler.java:21)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.handling.internal.MethodHandler.handle(MethodHandler.java:44)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.handling.internal.DefaultContext.insert(DefaultContext.java:179)\n\tat ratpack.path.internal.PathHandler.handle(PathHandler.java:61)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.path.internal.PathHandler.handle(PathHandler.java:63)\n\tat ratpack.handling.internal.DefaultContext.next(DefaultContext.java:157)\n\tat ratpack.handling.internal.DefaultContext.lambda$start$4(DefaultContext.java:104)\n\tat ratpack.exec.internal.DefaultExecution.lambda$new$0(DefaultExecution.java:79)\n\tat ratpack.exec.internal.DefaultExecution$InitialExecStream.exec(DefaultExecution.java:361)\n\tat ratpack.exec.internal.DefaultExecution.exec(DefaultExecution.java:196)\n\tat ratpack.exec.internal.DefaultExecution.intercept(DefaultExecution.java:189)\n\tat ratpack.exec.internal.DefaultExecution.drain(DefaultExecution.java:169)\n\tat ratpack.exec.internal.DefaultExecution.<init>(DefaultExecution.java:93)\n\tat ratpack.exec.internal.DefaultExecController$1.lambda$start$0(DefaultExecController.java:195)\n\tat io.netty.util.concurrent.PromiseTask.run(PromiseTask.java:73)\n\tat io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:163)\n\tat io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:403)\n\tat io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:442)\n\tat io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:858)\n\tat ratpack.exec.internal.DefaultExecController$ExecControllerBindingThreadFactory.lambda$newThread$0(DefaultExecController.java:136)\n\tat io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)\n\tat java.lang.Thread.run(Thread.java:745)\n"
        }

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/ratpack-errorhandler-example/issues).

## License
MIT License

Copyright (c) 2017 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.