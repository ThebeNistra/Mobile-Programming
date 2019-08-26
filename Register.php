<?php
	$con=mysqli_connect("localhost","id1055130_fbader","pass123","id1055130_fbader");
	if($con){
		echo "successss";
	
	$name=$_POST["name"];
	$username=$_POST["username"];
	$password=$_POST["password"];
	
	$statement= mysqli_prepare($con, "INSERT INTO user(name,username,password)
	VALUES (?,?,?)" );
	//passing parameters to $statement
	mysqli_stmt_bind_param($statement,"sss",$name,$username,$password);
	mysqli_stmt_execute($statement);
	
	$response=array();
	$response["success"]=true;
	
	echo json_encode($response);
	}
	else{
	echo "faaaaail";
	}
	
	//mysqli_stmt_close($statement);
	//mysqli_close($con);
?>