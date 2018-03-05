#include <iostream>
using namespace std;
int main()
{
    int n,min, max;
    cin >> n;
    int arr[n];
    for(int i = 0 ; i < n ; i++)
    {
        cout << i+1 << ".";
        cin >> arr[i];
        if(i==0){
            min=arr[i];
            max=arr[i];
        }
        if(arr[i]>max){
            max = arr[i];
        }
        if(arr[i]<min){
            min = arr[i];
        }
    }
    cout << "Max is:\t" << max << endl;
    cout << "Min is:\t" << min << endl;
}