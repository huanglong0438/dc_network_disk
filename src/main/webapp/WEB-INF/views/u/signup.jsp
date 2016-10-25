<%@include file="../header.jsp" %>

    <div class="container">
      <form class="form-signin" action="<c:url value="/u/weblogin"/>" method="post">
        <h2 class="form-signin-heading">Please sign up</h2>
        <label for="username" class="sr-only">username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        
        <label for="inputPassword" class="sr-only">password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <label for="email" class="sr-only">email</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Email" required>
        <label for="verifyCode" class="sr-only">verify code</label>
        <input type="text" id="verifyCode" name="verifyCode" class="form-control" placeholder="verify code" required>
        <button class="btn btn-lg btn-danger btn-block" onclick="window.location='<c:url value="/u/signup"/>'">Sign up</button>
      </form>
    </div> <!-- /container -->
</body>
</html>