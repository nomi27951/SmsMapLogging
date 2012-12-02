<?php
//File to intercept data from andriod app.
if($_SERVER['REQUEST_METHOD']=='POST')
{
	$cnic = $_POST['cnic'];
	$complaint = $_POST['complaint'];
	$long = $_POST['longitude'];
	$lat = $_POST['latitude'];
	require 'classes/db.php';
	
	$objdb = new SanDB();
	$objdb->sToDB($cnic,$long,$lat,$complaint);
	
	
	
}
?>