// 202235090 LEE JAEHYEOK
#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<time.h>


#define true 1
#define false 0

int cnt = 0;
pthread_mutex_t mutex;
int cntPrime(int num)
{
   int cnt = 0;
   int i;

   if (num < 2) return false;

   for (i=1; i*i<num; i++) {
      if (num%i == 0) cnt++;
   }
   if (i*i == num) cnt++;
   if (cnt == 1) return true;
   else return false;
}

void* partial_prime(void* param) {
   int range = *(int*)param;
   printf("thread for range %d ~ %d\n", range, range + 99999);

   //mutex lock use
   pthread_mutex_lock(&mutex);
   for (int i = range; i < range + 100000; i++) {
      if (i != 1) {
         if (cntPrime(i) == true) {
            cnt++;
         }
      }
   }
   pthread_mutex_unlock(&mutex);
   pthread_exit(0);
}

int main(int argc, char* argv[]) {
   int range = atoi(argv[1]);

   struct timespec start, finish;
   double elapsed;

   //add time clock
   clock_gettime(CLOCK_MONOTONIC, &start);
   //add initiatl mutex lock
   pthread_mutex_init(&mutex, NULL);

   int num_thread = 0;
   pthread_t tids[1024];
   int limit[1024];

   int idx = 0;
   while (idx < range) {
      limit[num_thread] = idx;
      //create threads
      pthread_create(&tids[num_thread], NULL, partial_prime, (void*)&limit[num_thread]);
      num_thread++;
      idx += 100000;
      if (idx + 1 > range) {
         idx = range;
      }
   }

   //add logic wait
   for (int i = 0; i < num_thread; i++) {
      pthread_join(tids[i], NULL);
   }
   //add clock difference
   clock_gettime(CLOCK_MONOTONIC, &finish);

   elapsed = (finish.tv_sec - start.tv_sec);
   elapsed += (finish.tv_nsec - start.tv_nsec) / 1000000000.0;

   printf("elpased time: %f sec \n", elapsed);
   printf("The number of prime numbers between 1 ~ %d: %d\n", range, cnt);

   return 0;
}