interface IHash {
  [key: string]: string;
}

export class HashMap {
  private map: IHash = {};

  add(key: string, value: string) {
    this.map[key] = value;
  }

  get(key: string) {
    return this.map[key];
  }
}
