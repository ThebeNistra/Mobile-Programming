<?php
	$con=mysqli_connect("localhost","id1055130_fbader","pass123","id1055130_fbader");
	
	$username=$_POST["username"];
	echo $username;
	$password=$_POST["password"];
	
	$statement=mysqli_prepare($con, "SELECT * FROM user WHERE username=?
	AND password=?");
	mysqli_stmt_bind_param($statement,"ss",$username,$password);
	mysqli_stmt_execute($statement);
	
	//mysqli_stmt_close($statement);
	
	//store result
	mysqli_stmt_result($statement);
	//name each field
	mysqli_start_bind_result($statement,$userID,$name,$username,$password);
	
	//hold data the results
	$user= array();
	$user["success"]=false;
	
	while(mysqli_stmt_fetch($statement)){
		$user["success"]=true;
		$user[name]=$name;
		//$user[age]=$age;
		$user[useranme]=$username;
		$user[password]=$password;
	}
	//send array to the phone
	echo json_encode($user);
	
	//mysqli_stmt_close($statement);
	//mysqli_close($con);
?>