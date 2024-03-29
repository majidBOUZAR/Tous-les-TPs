echo on
%    NEWFF   - Inititializes feed-forward networks.
%    TRAINGDX - Trains a feed-forward network with faster backpropagation.
%    SIM   - Simulates feed-forward networks.
%    CHARACTER RECOGNITION:
%    Using the above functions a feed-forward network is trained
%    to recognize character bit maps, in the presence of noise.
%    DEFINING THE MODEL PROBLEM
%    ==========================
%    The script file PRPROB defines a matrix ALPHABET
%    which contains the bit maps of the 26 letters of the
%    alphabet.
%    This file also defines target vectors TARGETS for
%    each letter.  Each target vector has 26 elements with
%    all zeros, except for a single 1.  A has a 1 in the
%    first element, B in the second, etc.
[alphabet,targets] = prprob;%PRPROB Character recognition problem definition
P=alphabet;
i=1;
%le caract�re A
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);
disp('c est  le  caract�re N�'),i

i=2;
%le caract�re B
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);

disp('c est  le  caract�re N�'),i

i=3;
%le caract�re C
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);

disp('c est  le  caract�re N�'),i
%%%%%%%........................................
%..........................jusqu'au i =26 => La lettre Z


%D�claration du NEURAL NET 
[R,Q] = size(alphabet);
[S2,Q] = size(targets);
%    DEFINING THE NETWORK
%    ====================
%    The character recognition network will have 25 TANSIG
%    neurons in its hidden layer.
S1 = 10;
net = newff(minmax(alphabet),[S1 S2],{'logsig' 'logsig'},'traingdx');
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
P = alphabet;
T = targets;
[net,tr] = train(net,P,T);
%    ...and finally finishes.
%    TRAINING THE NETWORK WITH NOISE
%    ===============================
%    A copy of the network will now be made.  This copy will
%    be trained with noisy examples of letters of the alphabet.
netn = net;
netn.trainParam.goal = 0.6;    % Mean-squared error goal.
netn.trainParam.epochs = 300;  % Maximum number of epochs to train.
%    The network will be trained on 10 sets of noisy data.
%    Training begins...please wait...
T = [targets targets targets targets];
for pass = 1:10
  fprintf('Pass = %.0f\n',pass);
  P = [alphabet, alphabet, ...
      (alphabet + randn(R,Q)*0.1), ...
      (alphabet + randn(R,Q)*0.2)];
  [netn,tr] = train(netn,P,T);
  echo off
end
echo on
%    ...and finally finishes.
%    TRAINING THE SECOND NETWORK WITHOUT NOISE
%    =========================================
%    The second network is now retrained without noise to
%    insure that it correctly categorizes non-noizy letters.
netn.trainParam.goal = 0.1;    % Mean-squared error goal.
netn.trainParam.epochs = 500;  % Maximum number of epochs to train.
netn.trainParam.show = 5;       % Frequency of progress displays (in epochs).
%    Training begins...please wait...
P = alphabet;
T = targets;
[netn,tr] = train(netn,P,T);
%    ...and finally finishes.
%      test sans bruit          %%%%%%%%%%%%%%%%%% 
i=4;
%le caract�re D
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(net,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

i=1;
%le caract�re A
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(net,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

i=2;
%le caract�re B
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(net,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

i=3;
%le caract�re C
noisy = P(:,i);%+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(net,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

%test De performance du RN
cpt=0;err=0;%straight
for i=1:26,%<----------------------
%les caract�res A,B,......,Z
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

%      test Avec bruit          %%%%%%%%%%%%%%%%%% 
i=4;
%le caract�re D
noisy = P(:,i)+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(netn,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

i=1;
%le caract�re A
noisy = P(:,i)+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(netn,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

i=2;
%le caract�re B
noisy = P(:,i)+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(netn,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

i=3;
%le caract�re C
noisy = P(:,i)+randn(35,1) * 0.2;
figure,plotchar(noisy);
A2 = sim(netn,noisy);
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i

%test Des performance du RN
cpt=0;err=0;%straight
for i=1:26,%<----------------------
%les caract�res A,B,......,Z
noisy = P(:,i)+randn(35,1) * 0.2;%<-------------------
figure,plotchar(noisy);
A2 = sim(netn,noisy);%<--------------------------
A2 = compet(A2);
answer= find(compet(A2) == 1);
disp('c est  le  caract�re N�'),i
pause;
if (answer==i) cpt=cpt+1;close;
  else   err=err+1;disp('l erreur est:'),figure,plotchar(P(:,answer)),disp('au lieu du caract�re'),
         figure,plotchar(P(:,i)),pause; 
  end;

end;
disp('nombre de reconnaissance correcte est :'),cpt
disp('nombre d erreur de reconnaissance est :'),err