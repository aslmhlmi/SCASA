
<%
			
		date_default_timezone_set('Asia/Kuala_Lumpur');
		$rfid = $_GET['rfid'];
		$temp = $_GET['temp'];
		$date = date("d/m/Y");
		$time = date("H:i") ;
		include_once("connect.php");
				$query="SELECT * FROM student_data WHERE rfid='$rfid'";
				$data_check=mysqli_query($mysqli,$query);
				$check=mysqli_num_rows($data_check);
				
				$qq1="SELECT class_id,subject  from classroom_timetable where '$time' between time_start and time_end";
		       $result11=mysqli_query($mysqli,$qq1); 
		        while ($row = mysqli_fetch_array($result11))
		            {
		                $class_id=$row['class_id'];
		                $subject=$row['subject'];
		            }
				
		    
				
		if($check>0)
		{
		    $query1="SELECT * FROM attendance_record WHERE rfid='$rfid' AND time_out LIKE '' AND date='$date'";
			$data_check1=mysqli_query($mysqli,$query1);
			$check1=mysqli_num_rows($data_check1);
		
		if($check1>0)
		{
		    
		  $update="UPDATE attendance_record SET time_out='$time' WHERE rfid='$rfid' and time_out LIKE '' ";
		  $result3=mysqli_query($mysqli,$update);   
		  echo "Bye Bye ";
		}
		else{
		$result = "INSERT INTO attendance_record(rfid,date,time_in,time_out,body_temp,class_id,subject) 
				VALUES('$rfid','$date','$time','','$temp','$class_id','$subject')";
		
		      if(mysqli_query($mysqli, $result)){
		          $qq="SELECT attendance_record.rfid,student_data.student_name  from attendance_record INNER JOIN student_data ON attendance_record.rfid=student_data.rfid where student_data.rfid='$rfid' GROUP BY rfid";
		       $result1=mysqli_query($mysqli,$qq); 
		        while ($row = mysqli_fetch_array($result1))
		            {
		                echo $row['student_name'];
		            }
		    } 
		    else {echo("Error description: " . $mysqli -> error);}
		    
		}
		}
		else 
		{	echo "Please Register"; 
		
			$Write="<?php $" . "UIDresult='" . $rfid . "'; " . "echo $" . "UIDresult;" . " ?>";
			file_put_contents('UIDContainer.jsp',$Write);
		    
		}

%>
