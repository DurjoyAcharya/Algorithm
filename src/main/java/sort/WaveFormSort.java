package sort;
//Sort an array in wave form
//Reff: https://www.geeksforgeeks.org/sort-array-wave-form-2/?ref=lbp

/**
 *Given an unsorted array of integers, sort the array into a wave array. An array arr[0..n-1] is sorted in wave form if:
 *arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= ….. 
 *Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 * Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} 
 * Explanation: 
 * here you can see {10, 5, 6, 2, 20, 3, 100, 80} first element is larger than the second and the same thing is repeated again and again. large element – small element-large element -small element and so on .it can be small element-larger element – small element-large element -small element too. all you need to maintain is the up-down fashion which represents a wave. there can be multiple answers.

 * Input: arr[] = {20, 10, 8, 6, 4, 2}
 *  Output: arr[] = {20, 8, 10, 4, 6, 2}
 *
 */
public class WaveFormSort{
  
}
