%Creation des targets pour l'apprentissage

target1 = [1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target2 = [0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target3 = [0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target4 = [0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target5 = [0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target6 = [0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target7 = [;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target8 = [0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target9 = [0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target10 = [0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target11 = [0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target12 = [0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0;0]
target13 = [0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0;0]
target14 = [0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0;0]
target15 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0;0]
target16 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0;0]
target17 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0;0]
target18 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0;0]
target19 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0;0]
target20 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0;0]
target21 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0;0]
target22 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0;0]
target23 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;0]
target24 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0]
target25 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1;0]
target26 = [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;1]

%targets = [target1,target2,target3,target4,target5,target6,target7,target8,target9,target10,target11,target12,target13,target14,target15,target16,target17,target18,target19,target20,target21,target22,target23,target24,target25,target26]

%creation de la matrice qui contient tous les matrices taregt
targets = [target1,target2,target3,target4,target5,target6]


 x1 =   [0 ; 0 ; 0 ; 0 ; 0 ;
        0 ; 0 ; 1 ; 0 ; 0 ; 
        0 ; 1 ; 1 ; 0 ; 0 ;
	    0 ; 0 ; 1 ; 0 ; 0 ;
	    0 ; 0 ; 1 ; 0 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
		0 ; 0 ; 0 ; 0 ; 0 ;
	   ]

	   
	   
 x2 = [  0 ; 0 ; 0 ; 0 ; 0 ;
        0 ; 1 ; 1 ; 1 ; 0 ; 
        0 ; 0 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
	    0 ; 1 ; 0 ; 0 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
		0 ; 0 ; 0 ; 0 ; 0 ;
	   ]

	  
 x3 = [ 0 ; 0 ; 0 ; 0 ; 0 ;
        0 ; 1 ; 1 ; 1 ; 0 ; 
        0 ; 0 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
	    0 ; 0 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
		0 ; 0 ; 0 ; 0 ; 0 ;
	   ]
	   
 x4 = [ 0 ; 0 ; 0 ; 0 ; 0 ;
        0 ; 1 ; 0 ; 0 ; 0 ; 
        0 ; 1 ; 0 ; 0 ; 0 ;
	    0 ; 1 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 1 ;
	    0 ; 0 ; 0 ; 1 ; 0 ;
		0 ; 0 ; 0 ; 0 ; 0 ;
	   ]
	   
	   
 x5 = [ 0 ; 0 ; 0 ; 0 ; 0 ;
        0 ; 1 ; 1 ; 1 ; 0 ; 
        0 ; 1 ; 0 ; 0 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
	    0 ; 0 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
		0 ; 0 ; 0 ; 0 ; 0 ;
	   ]


 
 x8 = [ 0 ; 0 ; 0 ; 0 ; 0 ;
        0 ; 1 ; 1 ; 1 ; 0 ; 
        0 ; 1 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
	    0 ; 1 ; 0 ; 1 ; 0 ;
	    0 ; 1 ; 1 ; 1 ; 0 ;
		0 ; 0 ; 0 ; 0 ; 0 ;
	   ]	   
	   
numbers = [x1,x2,x3,x4,x5,x8]	 



P=numbers;  


%Déclaration du NEURAL NET 
[R,Q] = size(numbers);
[S2,Q] = size(targets);
%    DEFINING THE NETWORK
%    ====================
%    The number recognition network will have 25 TANSIG
%    neurons in its hidden layer.
S1 = 10;
net = newff(minmax(numbers),[S1 S2],{'logsig' 'logsig'},'traingdx');
net.LW{2,1} = net.LW{2,1}*0.01;
net.b{2} = net.b{2}*0.01;
%    TRAINING THE NETWORK WITHOUT NOISE
%    ==================================
net.performFcn = 'sse';        % Sum-Squared Error performance function
net.trainParam.goal = 0.1;     % Sum-squared error goal.
net.trainParam.show = 20;      % Frequency of progress displays (in epochs).
net.trainParam.epochs = 5000;  % Maximum number of epochs to train.
net.trainParam.mc = 0.95;      % Momentum constant.
%    Training begins...please wait...
P = numbers;
T = targets;
[net,tr] = train(net,P,T);









