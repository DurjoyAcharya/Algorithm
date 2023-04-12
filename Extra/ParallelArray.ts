class ParallelArray {
  constructor() {}
  Partition(
    firstName: string[],
    lastName: string[],
    height: number[],
    low: number,
    high: number
  ): number {
    //lets assume a pivot number
    let pivot: number = height[high];
    let i: number = low - 1; //smallest element
    for (let index = 0; index < high - 1; index++) {
      if (height[index] <= pivot) {
        i++;
        let temp: string = firstName[i];
        firstName[i] = firstName[index];
        firstName[index] = temp;
        temp = lastName[i];
        lastName[i] = lastName[index];
        lastName[index] = temp;
        let temp1: number = height[i];
        height[i] = height[index];
        height[index] = temp1;
      }
    }
    let temp: string = firstName[i + 1];
    firstName[i + 1] = firstName[high];
    firstName[high] = temp;

    temp = lastName[i + 1];
    lastName[i + 1] = lastName[high];
    lastName[high] = temp;

    let temp1: number = height[i + 1];
    height[i + 1] = height[high];
    height[high] = temp1;
    return i + 1;
  }

  quickSort(
    firstName: string[],
    lastName: string[],
    height: number[],
    low: number,
    high: number
  ): void {
    if (low < high) {
      let pivot: number = this.Partition(
        firstName,
        lastName,
        height,
        low,
        high
      );
      this.quickSort(firstName, lastName, height, low, pivot - 1);
      this.quickSort(firstName, lastName, height, pivot + 1, high);
    }
  }
  binarySearch(
    firstName: string[],
    lastName: string[],
    height: number[],
    value: number,
    N: number
  ): void {
    let low: number = 0;
    let high: number = N - 1;
    let index: number;
    while (low <= high) {
      index = (high + low) / 2;
      if (height[index] == 158) {
        console.log(
          "Person having height 158 cms is " +
            firstName[index] +
            " " +
            lastName[index]
        );
        return;
      } else if (height[index] > 158) high = index - 1;
      else low = index + 1;
    }
    console.log("Sorry, no such person with height 158 cms");
    console.log("is found in the record");
  }

  displayParallelArray(
    firstName: string[],
    lastName: string[],
    height: number[]
  ): void {
    console.log("Name of people in increasing\n");
    console.log("Order of their height:\n");
    for (let index = 0; index < firstName.length; index++)
      console.log(
        firstName[index] +
          " " +
          lastName[index] +
          " has height " +
          height[index] +
          " cms\n"
      );
  }
}

let firstName: string[] = [
  "Bones",
  "Welma",
  "Frank",
  "Han",
  "Jack",
  "Jinny",
  "Harry",
  "Emma",
  "Tony",
  "Sherlock",
];

let lastName: string[] = [
  "Smith",
  "Seger",
  "Mathers",
  "Solo",
  "Jackles",
  "Weasly",
  "Potter",
  "Watson",
  "Stark",
  "Holmes",
];
let height: number[] = [169, 158, 201, 183, 172, 152, 160, 163, 173, 185];

let parallel = new ParallelArray();
parallel.quickSort(firstName, lastName, height, 0, 10 - 1);
parallel.displayParallelArray(firstName, lastName, height);
