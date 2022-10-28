% OCR (Optical Character Recognition).
% Author: Ing. Diego Barrag�n Guerrero 
% e-mail: diego@matpic.com
% For more information, visit: www.matpic.com
%________________________________________
% PRINCIPAL PROGRAM
warning off %#ok<WNOFF>
% Clear all
clc, close all, clear all
% Read image
imagen=imread('28.jpg');
% Show image
imshow(imagen);
title('INPUT IMAGE WITH NOISE')
% Convert to gray scale
if size(imagen,3)==3 %RGB image
    imagen=rgb2gray(imagen);
end
% Convert to BW
threshold = graythresh(imagen);
imagen =~im2bw(imagen,threshold);
% Remove all object containing fewer than 30 pixels
imagen = bwareaopen(imagen,30);
%Storage matrix word from image
word=[ ];
re=imagen;
% Load templates
load templates
global templates
% Compute the number of letters in template file
num_letras=size(templates,2);
while 1
    %Fcn 'lines' separate lines in text
    [fl re]=lines(re);
    imgn=fl;
    %Uncomment line below to see lines one by one
    %imshow(fl);pause(0.5)    
    %-----------------------------------------------------------------     
    % Label and count connected components
    [L Ne] = bwlabel(imgn);    
    for n=1:Ne
        [r,c] = find(L==n);
        % Extract letter
        n1=imgn(min(r):max(r),min(c):max(c));  
        % Resize letter (same size of template)
        img_r=imresize(n1,[42 24]);
        %Uncomment line below to see letters one by one
         %imshow(img_r);pause(0.5)
        %-------------------------------------------------------------------
        % Call fcn to convert image to text
        letter=read_letter(img_r,num_letras);
        % Letter concatenation
        word=[word letter];
    end
	
    %*When the sentences finish, breaks the loop
    if isempty(re)  %See variable 're' in Fcn 'lines'
        break
    end    
	
	
	
	
	
end








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
targets = [target1,target2,target3,target4,target5]



%Creation des matrice pour les nombres suivants 18, 28, 38, 48, 58

 x18 = [0 ; 1 ; 1 ; 1 ; 1 ; 
        1 ; 1 ; 1 ; 0 ; 1 ;
	    0 ; 1 ; 1 ; 1 ; 1 ;
	    0 ; 1 ; 1 ; 0 ; 1 ;
	    0 ; 1 ; 1 ; 1 ; 1 ;
	   ]

	  
 x28 = [1 ; 1 ; 1 ; 1 ; 1 ; 
        0 ; 1 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	    1 ; 0 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	   ]
	   
 x38 = [1 ; 1 ; 1 ; 1 ; 1 ; 
        0 ; 1 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	    0 ; 1 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	   ]

	   
 x48 = [1 ; 0 ; 1 ; 1 ; 1 ; 
        1 ; 0 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	    1 ; 1 ; 1 ; 0 ; 1 ;
	    0 ; 1 ; 1 ; 1 ; 1 ;
	   ]
	 
 x58 = [1 ; 1 ; 1 ; 1 ; 1 ; 
        1 ; 0 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	    0 ; 1 ; 1 ; 0 ; 1 ;
	    1 ; 1 ; 1 ; 1 ; 1 ;
	   ]	 
	  
	
%Creation de la matrice m�re qui contient toutes les matrices des nombre qu'on a cr�� 	  	   
numbers = [x18,x28,x38,x48,x58]

P=numbers;
numImg = word;

if numImg == '18'
%Afficher la figure du nombre 18
i=1;
noisy = P(:,i);
figure,plotchar(noisy);
disp('c est  le  caract�re N�'),i
end

if numImg == '28'
%Afficher la figure du nombre 18
i=2;
noisy = P(:,i);
figure,plotchar(noisy);
disp('c est  le  caract�re N�'),i
end

if numImg == '38'
%Afficher la figure du nombre 18
i=3;
noisy = P(:,i);
figure,plotchar(noisy);
disp('c est  le  caract�re N�'),i
end

if numImg == '48'

  %Afficher la figure du nombre 18
  i=4;
  noisy = P(:,i);
  figure,plotchar(noisy);
  disp('c est  le  caract�re N�'),i
end

if numImg == '58'
%Afficher la figure du nombre 18
i=5;
noisy = P(:,i);
figure,plotchar(noisy);
disp('c est  le  caract�re N�'),i
end


%D�claration du NEURAL NET 
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
%    ...and finally finishes.



% TRAINING THE NETWORK WITH NOISE
%    ===============================
%    A copy of the network will now be made.  This copy will
%    be trained with noisy examples of numbers.
netn = net;
netn.trainParam.goal = 0.6;    % Mean-squared error goal.
netn.trainParam.epochs = 300;  % Maximum number of epochs to train.
%    The network will be trained on 10 sets of noisy data.
%    Training begins...please wait...
T = [targets targets targets targets];
for pass = 1:10
  fprintf('Pass = %.0f\n',pass);
  P = [numbers, numbers, ...
      (numbers + randn(R,Q)*0.1), ...
      (numbers + randn(R,Q)*0.2)];
  [netn,tr] = train(netn,P,T);
  echo off
end
echo on

%    TRAINING THE SECOND NETWORK WITHOUT NOISE
%    =========================================
%    The second network is now retrained without noise to
%    insure that it correctly categorizes non-noizy numbers.
netn.trainParam.goal = 0.1;    % Mean-squared error goal.
netn.trainParam.epochs = 500;  % Maximum number of epochs to train.
netn.trainParam.show = 5;       % Frequency of progress displays (in epochs).
%    Training begins...please wait...
P = numbers;
T = targets;
[netn,tr] = train(netn,P,T);
%    ...and finally finishes.
%      test sans bruit          %%%%%%%%%%%%%%%%%% 





if numImg == '18'

	cpt=0;err=0;%straight
	for i=1,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i);%+randn(35,1) * 0.2;<-------------------
	figure,plotchar(noisy);
	A2 = sim(net,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close; 
	  else   err=err+1;
	  end;
	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '28'

	cpt=0;err=0;%straight
	for i=2,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i);%+randn(35,1) * 0.2;<-------------------
	figure,plotchar(noisy);
	A2 = sim(net,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close; 
	  else   err=err+1;
	  end;
	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '38'

	cpt=0;err=0;%straight
	for i=3,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i);%+randn(35,1) * 0.2;<-------------------
	figure,plotchar(noisy);
	A2 = sim(net,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close; 
	  else   err=err+1;
	  end;
	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '48'

	cpt=0;err=0;%straight
	for i=4,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i);%+randn(35,1) * 0.2;<-------------------
	figure,plotchar(noisy);
	A2 = sim(net,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close; 
	  else   err=err+1;
	  end;
	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '58'

	cpt=0;err=0;%straight
	for i=5,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i);%+randn(35,1) * 0.2;<-------------------
	figure,plotchar(noisy);
	A2 = sim(net,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close; 
	  else   err=err+1;
	  end;
	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end


   %%%%%%%%%%%%%%%%%%   test Avec bruit          %%%%%%%%%%%%%%%%%% 

if numImg == '18'

	i=1;
	%le nombre 18
	noisy = P(:,i)+randn(25,1) * 0.2;
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  nombre N�'),i

end

if numImg == '28'

	i=2;
	%le nombre 18
	noisy = P(:,i)+randn(25,1) * 0.2;
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  nombre N�'),i


end

if numImg == '38'

	i=3;
	%le nombre 18
	noisy = P(:,i)+randn(25,1) * 0.2;
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  nombre N�'),i


end

if numImg == '48'

	i=4;
	%le nombre 18
	noisy = P(:,i)+randn(25,1) * 0.2;
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  nombre N�'),i


end

if numImg == '58'

	i=5;
	%le nombre 18
	noisy = P(:,i)+randn(25,1) * 0.2;
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  nombre N�'),i


end







if numImg == '18'

	%test Des performance du RN
	cpt=0;err=0;%straight
	for i=1,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i)+randn(25,1) * 0.2;%<-------------------
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close;
	  else   err=err+1;disp('l erreur est:'),figure,plotchar(P(:,answer)),disp('au lieu du nombre'),
			 figure,plotchar(P(:,i)),pause; 
	  end;

	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '28'

	%test Des performance du RN
	cpt=0;err=0;%straight
	for i=2,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i)+randn(25,1) * 0.2;%<-------------------
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close;
	  else   err=err+1;disp('l erreur est:'),figure,plotchar(P(:,answer)),disp('au lieu du nombre'),
			 figure,plotchar(P(:,i)),pause; 
	  end;

	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '38'

	%test Des performance du RN
	cpt=0;err=0;%straight
	for i=3,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i)+randn(25,1) * 0.2;%<-------------------
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close;
	  else   err=err+1;disp('l erreur est:'),figure,plotchar(P(:,answer)),disp('au lieu du nombre'),
			 figure,plotchar(P(:,i)),pause; 
	  end;

	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '48'

	%test Des performance du RN
	cpt=0;err=0;%straight
	for i=4,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i)+randn(25,1) * 0.2;%<-------------------
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close;
	  else   err=err+1;disp('l erreur est:'),figure,plotchar(P(:,answer)),disp('au lieu du nombre'),
			 figure,plotchar(P(:,i)),pause; 
	  end;

	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

if numImg == '58'

	%test Des performance du RN
	cpt=0;err=0;%straight
	for i=5,%<----------------------
	%les nombres 18,28,38,48,58
	noisy = P(:,i)+randn(25,1) * 0.2;%<-------------------
	figure,plotchar(noisy);
	A2 = sim(netn,noisy);%<--------------------------
	A2 = compet(A2);
	answer= find(compet(A2) == 1);
	disp('c est  le  caract�re N�'),i
	pause;
	if (answer==i) cpt=cpt+1;close;
	  else   err=err+1;disp('l erreur est:'),figure,plotchar(P(:,answer)),disp('au lieu du nombre'),
			 figure,plotchar(P(:,i)),pause; 
	  end;

	end;
	disp('nombre de reconnaissance correcte est :'),cpt
	disp('nombre d erreur de reconnaissance est :'),err

end

